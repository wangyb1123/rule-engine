// Generated from E:\JavaWorks\rule-engine\rule-engine-core/src/main/resources/grammar/SqlGrammar.g4 by ANTLR 4.7.2
package com.everest.rule.sql.expr.parser.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SqlGrammarParser}.
 */
public interface SqlGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SqlGrammarParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(SqlGrammarParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlGrammarParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(SqlGrammarParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlGrammarParser#literalValue}.
	 * @param ctx the parse tree
	 */
	void enterLiteralValue(SqlGrammarParser.LiteralValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlGrammarParser#literalValue}.
	 * @param ctx the parse tree
	 */
	void exitLiteralValue(SqlGrammarParser.LiteralValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlGrammarParser#restriction}.
	 * @param ctx the parse tree
	 */
	void enterRestriction(SqlGrammarParser.RestrictionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlGrammarParser#restriction}.
	 * @param ctx the parse tree
	 */
	void exitRestriction(SqlGrammarParser.RestrictionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SqlGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SqlGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlGrammarParser#logicalTerm}.
	 * @param ctx the parse tree
	 */
	void enterLogicalTerm(SqlGrammarParser.LogicalTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlGrammarParser#logicalTerm}.
	 * @param ctx the parse tree
	 */
	void exitLogicalTerm(SqlGrammarParser.LogicalTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlGrammarParser#logicalFactor}.
	 * @param ctx the parse tree
	 */
	void enterLogicalFactor(SqlGrammarParser.LogicalFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlGrammarParser#logicalFactor}.
	 * @param ctx the parse tree
	 */
	void exitLogicalFactor(SqlGrammarParser.LogicalFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlGrammarParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(SqlGrammarParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlGrammarParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(SqlGrammarParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlGrammarParser#inList}.
	 * @param ctx the parse tree
	 */
	void enterInList(SqlGrammarParser.InListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlGrammarParser#inList}.
	 * @param ctx the parse tree
	 */
	void exitInList(SqlGrammarParser.InListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlGrammarParser#like}.
	 * @param ctx the parse tree
	 */
	void enterLike(SqlGrammarParser.LikeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlGrammarParser#like}.
	 * @param ctx the parse tree
	 */
	void exitLike(SqlGrammarParser.LikeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlGrammarParser#has}.
	 * @param ctx the parse tree
	 */
	void enterHas(SqlGrammarParser.HasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlGrammarParser#has}.
	 * @param ctx the parse tree
	 */
	void exitHas(SqlGrammarParser.HasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlGrammarParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(SqlGrammarParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlGrammarParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(SqlGrammarParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlGrammarParser#validation}.
	 * @param ctx the parse tree
	 */
	void enterValidation(SqlGrammarParser.ValidationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlGrammarParser#validation}.
	 * @param ctx the parse tree
	 */
	void exitValidation(SqlGrammarParser.ValidationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlGrammarParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(SqlGrammarParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlGrammarParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(SqlGrammarParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlGrammarParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(SqlGrammarParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlGrammarParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(SqlGrammarParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlGrammarParser#methodArg}.
	 * @param ctx the parse tree
	 */
	void enterMethodArg(SqlGrammarParser.MethodArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlGrammarParser#methodArg}.
	 * @param ctx the parse tree
	 */
	void exitMethodArg(SqlGrammarParser.MethodArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlGrammarParser#objectProperty}.
	 * @param ctx the parse tree
	 */
	void enterObjectProperty(SqlGrammarParser.ObjectPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlGrammarParser#objectProperty}.
	 * @param ctx the parse tree
	 */
	void exitObjectProperty(SqlGrammarParser.ObjectPropertyContext ctx);
}