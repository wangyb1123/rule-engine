package com.everest.rule.parser.sql;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.everest.rule.Utils;
import com.everest.rule.parser.*;
import com.everest.rule.parser.column.ObjectWrapperColumnNameConvertor;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.everest.rule.RuleContext;
import com.everest.rule.parser.column.ColumnNameConvertor;
import com.everest.rule.sql.expr.parser.generated.SqlGrammarBaseVisitor;
import com.everest.rule.sql.expr.parser.generated.SqlGrammarParser;
import com.google.common.collect.Lists;

public class SqlVisitor<T extends Filter<?>> extends SqlGrammarBaseVisitor<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SqlVisitor.class);

    private final StringFilterBuilder<T> filterBuilder;

    private final ColumnNameConvertor convertor;

    private final RuleContext ruleContext;

    public SqlVisitor(StringFilterBuilder<T> filterBuilder, RuleContext ruleContext) {
        this(filterBuilder, new ObjectWrapperColumnNameConvertor(), ruleContext);
    }

    public SqlVisitor(StringFilterBuilder<T> filterBuilder,
            ColumnNameConvertor convertor, RuleContext ruleContext) {
        super();
        this.filterBuilder = filterBuilder;
        this.convertor = convertor;
        this.ruleContext = ruleContext;
    }

    @Override
    public T visitRestriction(SqlGrammarParser.RestrictionContext ctx) {
        LOGGER.trace("Input filter string: {}", ctx.getText());
        T result = ctx.getChild(0).accept(this);
        LOGGER.trace("Filter buit from string: {}", result);
        return filterBuilder.build();
    }

    @Override
    public T visitExpr(SqlGrammarParser.ExprContext ctx) {
        // visitLogicalTerm or visitLogicalTerm
        List<T> result = Lists.newArrayList();
        for (int i = 0; i < ctx.getChildCount(); i = i + 2) {
            result.add(ctx.getChild(i).accept(this));
        }
        return result.size() == 1 ? result.get(0) : filterBuilder.or(result);
    }

    @Override
    public T visitLogicalTerm(SqlGrammarParser.LogicalTermContext ctx) {
        List<T> result = Lists.newArrayList();
        // visitLogicalFactor and visitLogicalFactor
        for (int i = 0; i < ctx.getChildCount(); i = i + 2) {
            result.add(ctx.getChild(i).accept(this));
        }
        return result.size() == 1 ? result.get(0) : filterBuilder.and(result);
    }

    @Override
    public T visitLogicalFactor(SqlGrammarParser.LogicalFactorContext ctx) {
        T result = visitChildren(ctx);
        return ctx.NOT_() != null ? filterBuilder.not(result) : result;
    }

    @Override
    public T visitPredicate(SqlGrammarParser.PredicateContext ctx) {
        T result = null;
        if (ctx.expr() != null) {
            result = ctx.expr().accept(this);
        } else if (ctx.TRUE_() != null) {
            result = filterBuilder.alwaysTrue();
        } else if (ctx.FALSE_() != null) {
            result = filterBuilder.alwaysFalse();
        } else {
            result = visitChildren(ctx);
        }
        return result;
    }

    @Override
    public T visitInList(SqlGrammarParser.InListContext ctx) {
        List<?> values = ctx.literalValue().stream()
                .map(e -> this.getLiteralValue(e).getValue())
                .collect(Collectors.toList());
        if (ctx.columnName().funcCall() != null) {
            String methodName = ctx.columnName().funcCall().IDENTIFIER()
                    .getText();
            LOGGER.info("function call with method name: " + methodName);
            Optional<List<?>> args = Optional.empty();
            if (ctx.columnName().funcCall().argList() != null) {
                args = Optional.of(getArgList(ctx.columnName().funcCall()
                        .argList()));
            }
            return filterBuilder.functionFilter(methodName,
                    args.orElse(List.of()), values, FilterOperator.IN,
                    ruleContext);
        }
        return filterBuilder.customizedFilter(
                convertor.convert(ctx.columnName().getText()), values,
                FilterOperator.IN, ruleContext);
    }

    @Override
    public T visitLike(SqlGrammarParser.LikeContext ctx) {
        return filterBuilder.customizedFilter(
                convertor.convert(ctx.columnName().getText()),
                Lists.newArrayList(getLiteralValue(ctx.String()).getValue()),
                FilterOperator.LIKE, ruleContext);
    }

    @Override
    public T visitHas(SqlGrammarParser.HasContext ctx) {
        return filterBuilder.customizedFilter(
                convertor.convert(ctx.columnName().getText()),
                Lists.newArrayList(getLiteralValue(ctx.String()).getValue()),
                FilterOperator.HAS, ruleContext);
    }

    @Override
    public T visitComparison(SqlGrammarParser.ComparisonContext ctx) {
        if (ctx.columnName().funcCall() != null) {
            String methodName = ctx.columnName().funcCall().IDENTIFIER()
                    .getText();
            LOGGER.info("function call with method name: " + methodName);
            Optional<List<?>> args = Optional.empty();
            if (ctx.columnName().funcCall().argList() != null) {
                args = Optional.of(getArgList(ctx.columnName().funcCall()
                        .argList()));
            }
            return filterBuilder.functionFilter(methodName, args.orElse(List
                    .of()), Lists.newArrayList(getLiteralValue(
                    ctx.literalValue()).getValue()), getOperator(ctx),
                    ruleContext);
        }
        return filterBuilder.customizedFilter(convertor.convert(ctx
                .columnName().getText()), Lists.newArrayList(getLiteralValue(
                ctx.literalValue()).getValue()), getOperator(ctx), ruleContext);
    }

    @Override
    public T visitValidation(SqlGrammarParser.ValidationContext ctx) {
        LOGGER.info("visit validation");
        LOGGER.info("function: " + ctx.getText());
        LOGGER.info("function name: " + ctx.IDENTIFIER());
        LOGGER.info("function argList: " + ctx.argList().getText());
        List<?> args = getArgList(ctx.argList());
        return filterBuilder.functionFilter(ctx.IDENTIFIER().getText(), args,
                List.of(Boolean.TRUE), FilterOperator.EQUALS, ruleContext);
    }

    @Override
    public T visitArgList(SqlGrammarParser.ArgListContext ctx) {
        LOGGER.info("argList: " + ctx.getText());
        return visitChildren(ctx);
    }

    public T visitMethodArg(SqlGrammarParser.MethodArgContext ctx) {
        if (ctx.literalValue() != null) {
            LOGGER.info("simple arg:"
                    + getLiteralValue(ctx.literalValue()).getValue());
        }
        return visitChildren(ctx);
    }

    private FilterOperator getOperator(SqlGrammarParser.ComparisonContext ctx) {
        if (ctx.EQ_() != null) {
            return FilterOperator.EQUALS;
        } else if (ctx.LE_() != null) {
            return FilterOperator.LESS_THAN_OR_EQUALS;
        } else if (ctx.LT_() != null) {
            return FilterOperator.LESS_THAN;
        } else if (ctx.GE_() != null) {
            return FilterOperator.GREAT_THAN_OR_EQUALS;
        } else if (ctx.GT_() != null) {
            return FilterOperator.GREATER_THAN;
        } else {
            return FilterOperator.NOT_EQUALS;
        }
    }
    
    private LiteralValue<?> getLiteralValue(ParserRuleContext context){
        TerminalNode node = (TerminalNode) context.getChild(0);
        return getLiteralValue(node);
    }

    private LiteralValue<?> getLiteralValue(TerminalNode node) {
        if(node.getSymbol().getType()==SqlGrammarParser.String){
            return new LiteralValue<String>(node.getText().substring(1, node.getText().length()-1));
        }else if(node.getSymbol().getType()==SqlGrammarParser.Number) {
            if(node.getText().contains(".")){
                return new LiteralValue<Double>(Double.valueOf(node.getText()));
            }else{
                return new LiteralValue<Long>(Long.valueOf(node.getText()));
            }
        }else if(node.getSymbol().getType()==SqlGrammarParser.ISO_DATE) {
            return new LiteralValue<LocalDate>(Utils.stringToDate(node.getText().substring(node.getText().indexOf('(')+1, node.getText().indexOf(')')), DateTimeFormatter.ISO_DATE));
        }else if(node.getSymbol().getType()==SqlGrammarParser.ISO_DATE_TIME) {
            return new LiteralValue<LocalDate>(Utils.stringToDate(node.getText().substring(node.getText().indexOf('(')+1, node.getText().indexOf(')')), DateTimeFormatter.ISO_DATE_TIME));
        }else if(node.getSymbol().getType()==SqlGrammarParser.TRUE_){
            return new LiteralValue<Boolean>(true);
        }else if(node.getSymbol().getType()==SqlGrammarParser.FALSE_){
            return new LiteralValue<Boolean>(false);
        }else if(node.getSymbol().getType()==SqlGrammarParser.NULL_){
            return new LiteralValue<String>(null);
        }
        throw new UnsupportedOperationException("Unrecoginized data type: " + node.getSymbol().getType());
    }
    
    private List<?> getArgList(SqlGrammarParser.ArgListContext ctx){
        List<?> args = ctx.methodArg().stream().map(e->{
            if(e.literalValue()!=null){
                return this.getLiteralValue(e.literalValue()).getValue();
            }else{
                return FunctionCall.ATTRIBUTE_PREFIX + e.objectProperty().getText();
            }
        }).collect(Collectors.toList());
        LOGGER.info("args" + args);
        return args;
    }

}
