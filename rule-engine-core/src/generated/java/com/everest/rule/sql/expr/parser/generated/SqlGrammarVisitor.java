// Generated from E:\JavaWorks\rule-engine\rule-engine-core/src/main/resources/grammar/SqlGrammar.g4 by ANTLR 4.7.2
package com.everest.rule.sql.expr.parser.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SqlGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SqlGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SqlGrammarParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(SqlGrammarParser.ColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlGrammarParser#literalValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralValue(SqlGrammarParser.LiteralValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlGrammarParser#restriction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestriction(SqlGrammarParser.RestrictionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SqlGrammarParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlGrammarParser#logicalTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalTerm(SqlGrammarParser.LogicalTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlGrammarParser#logicalFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalFactor(SqlGrammarParser.LogicalFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlGrammarParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(SqlGrammarParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlGrammarParser#inList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInList(SqlGrammarParser.InListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlGrammarParser#like}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLike(SqlGrammarParser.LikeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlGrammarParser#has}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHas(SqlGrammarParser.HasContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlGrammarParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(SqlGrammarParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlGrammarParser#validation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidation(SqlGrammarParser.ValidationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlGrammarParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(SqlGrammarParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlGrammarParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(SqlGrammarParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlGrammarParser#methodArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodArg(SqlGrammarParser.MethodArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlGrammarParser#objectProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectProperty(SqlGrammarParser.ObjectPropertyContext ctx);
}