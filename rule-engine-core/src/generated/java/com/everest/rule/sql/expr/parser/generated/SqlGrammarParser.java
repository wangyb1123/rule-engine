// Generated from E:\JavaWorks\rule-engine\rule-engine-core/src/main/resources/grammar/SqlGrammar.g4 by ANTLR 4.7.2
package com.everest.rule.sql.expr.parser.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, OR_=2, AND_=3, NOT_=4, IN_=5, HAS_=6, LIKE_=7, GT_=8, LT_=9, GE_=10, 
		LE_=11, NE_=12, EQ_=13, LP_=14, RP_=15, TRUE_=16, FALSE_=17, NULL_=18, 
		IDENTIFIER=19, ISO_DATE=20, ISO_DATE_TIME=21, Number=22, String=23, COMMA=24, 
		DOT=25, SPACE=26, WHITESPACES=27;
	public static final int
		RULE_columnName = 0, RULE_literalValue = 1, RULE_restriction = 2, RULE_expr = 3, 
		RULE_logicalTerm = 4, RULE_logicalFactor = 5, RULE_predicate = 6, RULE_inList = 7, 
		RULE_like = 8, RULE_has = 9, RULE_comparison = 10, RULE_validation = 11, 
		RULE_funcCall = 12, RULE_argList = 13, RULE_methodArg = 14, RULE_objectProperty = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"columnName", "literalValue", "restriction", "expr", "logicalTerm", "logicalFactor", 
			"predicate", "inList", "like", "has", "comparison", "validation", "funcCall", 
			"argList", "methodArg", "objectProperty"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'#'", null, null, null, null, null, null, "'>'", "'<'", "'>='", 
			"'<='", "'<>'", "'='", "'('", "')'", null, null, null, null, null, null, 
			null, null, "','", "'.'", "' '", "'\n\r\t'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "OR_", "AND_", "NOT_", "IN_", "HAS_", "LIKE_", "GT_", "LT_", 
			"GE_", "LE_", "NE_", "EQ_", "LP_", "RP_", "TRUE_", "FALSE_", "NULL_", 
			"IDENTIFIER", "ISO_DATE", "ISO_DATE_TIME", "Number", "String", "COMMA", 
			"DOT", "SPACE", "WHITESPACES"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SqlGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SqlGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ColumnNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlGrammarParser.IDENTIFIER, 0); }
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).exitColumnName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlGrammarVisitor ) return ((SqlGrammarVisitor<? extends T>)visitor).visitColumnName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_columnName);
		try {
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				match(T__0);
				setState(34);
				match(IDENTIFIER);
				setState(35);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				funcCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralValueContext extends ParserRuleContext {
		public TerminalNode ISO_DATE() { return getToken(SqlGrammarParser.ISO_DATE, 0); }
		public TerminalNode ISO_DATE_TIME() { return getToken(SqlGrammarParser.ISO_DATE_TIME, 0); }
		public TerminalNode Number() { return getToken(SqlGrammarParser.Number, 0); }
		public TerminalNode String() { return getToken(SqlGrammarParser.String, 0); }
		public TerminalNode TRUE_() { return getToken(SqlGrammarParser.TRUE_, 0); }
		public TerminalNode FALSE_() { return getToken(SqlGrammarParser.FALSE_, 0); }
		public TerminalNode NULL_() { return getToken(SqlGrammarParser.NULL_, 0); }
		public LiteralValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).enterLiteralValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).exitLiteralValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlGrammarVisitor ) return ((SqlGrammarVisitor<? extends T>)visitor).visitLiteralValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralValueContext literalValue() throws RecognitionException {
		LiteralValueContext _localctx = new LiteralValueContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_literalValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE_) | (1L << FALSE_) | (1L << NULL_) | (1L << ISO_DATE) | (1L << ISO_DATE_TIME) | (1L << Number) | (1L << String))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RestrictionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlGrammarParser.EOF, 0); }
		public RestrictionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_restriction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).enterRestriction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).exitRestriction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlGrammarVisitor ) return ((SqlGrammarVisitor<? extends T>)visitor).visitRestriction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RestrictionContext restriction() throws RecognitionException {
		RestrictionContext _localctx = new RestrictionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_restriction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			expr();
			setState(42);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<LogicalTermContext> logicalTerm() {
			return getRuleContexts(LogicalTermContext.class);
		}
		public LogicalTermContext logicalTerm(int i) {
			return getRuleContext(LogicalTermContext.class,i);
		}
		public List<TerminalNode> OR_() { return getTokens(SqlGrammarParser.OR_); }
		public TerminalNode OR_(int i) {
			return getToken(SqlGrammarParser.OR_, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlGrammarVisitor ) return ((SqlGrammarVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			logicalTerm();
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR_) {
				{
				{
				setState(45);
				match(OR_);
				setState(46);
				logicalTerm();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalTermContext extends ParserRuleContext {
		public List<LogicalFactorContext> logicalFactor() {
			return getRuleContexts(LogicalFactorContext.class);
		}
		public LogicalFactorContext logicalFactor(int i) {
			return getRuleContext(LogicalFactorContext.class,i);
		}
		public List<TerminalNode> AND_() { return getTokens(SqlGrammarParser.AND_); }
		public TerminalNode AND_(int i) {
			return getToken(SqlGrammarParser.AND_, i);
		}
		public LogicalTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).enterLogicalTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).exitLogicalTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlGrammarVisitor ) return ((SqlGrammarVisitor<? extends T>)visitor).visitLogicalTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalTermContext logicalTerm() throws RecognitionException {
		LogicalTermContext _localctx = new LogicalTermContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_logicalTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			logicalFactor();
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND_) {
				{
				{
				setState(53);
				match(AND_);
				setState(54);
				logicalFactor();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalFactorContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode NOT_() { return getToken(SqlGrammarParser.NOT_, 0); }
		public LogicalFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalFactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).enterLogicalFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).exitLogicalFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlGrammarVisitor ) return ((SqlGrammarVisitor<? extends T>)visitor).visitLogicalFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalFactorContext logicalFactor() throws RecognitionException {
		LogicalFactorContext _localctx = new LogicalFactorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_logicalFactor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT_) {
				{
				setState(60);
				match(NOT_);
				}
			}

			setState(63);
			predicate();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public InListContext inList() {
			return getRuleContext(InListContext.class,0);
		}
		public LikeContext like() {
			return getRuleContext(LikeContext.class,0);
		}
		public HasContext has() {
			return getRuleContext(HasContext.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode TRUE_() { return getToken(SqlGrammarParser.TRUE_, 0); }
		public TerminalNode FALSE_() { return getToken(SqlGrammarParser.FALSE_, 0); }
		public ValidationContext validation() {
			return getRuleContext(ValidationContext.class,0);
		}
		public TerminalNode LP_() { return getToken(SqlGrammarParser.LP_, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP_() { return getToken(SqlGrammarParser.RP_, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).exitPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlGrammarVisitor ) return ((SqlGrammarVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_predicate);
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				inList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				like();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				has();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				comparison();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				match(TRUE_);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(70);
				match(FALSE_);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(71);
				validation();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(72);
				match(LP_);
				setState(73);
				expr();
				setState(74);
				match(RP_);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InListContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode IN_() { return getToken(SqlGrammarParser.IN_, 0); }
		public TerminalNode LP_() { return getToken(SqlGrammarParser.LP_, 0); }
		public List<LiteralValueContext> literalValue() {
			return getRuleContexts(LiteralValueContext.class);
		}
		public LiteralValueContext literalValue(int i) {
			return getRuleContext(LiteralValueContext.class,i);
		}
		public TerminalNode RP_() { return getToken(SqlGrammarParser.RP_, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlGrammarParser.COMMA, i);
		}
		public InListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).enterInList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).exitInList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlGrammarVisitor ) return ((SqlGrammarVisitor<? extends T>)visitor).visitInList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InListContext inList() throws RecognitionException {
		InListContext _localctx = new InListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_inList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			columnName();
			setState(79);
			match(IN_);
			setState(80);
			match(LP_);
			setState(81);
			literalValue();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(82);
				match(COMMA);
				setState(83);
				literalValue();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
			match(RP_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LikeContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode LIKE_() { return getToken(SqlGrammarParser.LIKE_, 0); }
		public TerminalNode String() { return getToken(SqlGrammarParser.String, 0); }
		public LikeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_like; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).enterLike(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).exitLike(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlGrammarVisitor ) return ((SqlGrammarVisitor<? extends T>)visitor).visitLike(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LikeContext like() throws RecognitionException {
		LikeContext _localctx = new LikeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_like);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			columnName();
			setState(92);
			match(LIKE_);
			setState(93);
			match(String);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HasContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode HAS_() { return getToken(SqlGrammarParser.HAS_, 0); }
		public TerminalNode String() { return getToken(SqlGrammarParser.String, 0); }
		public HasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_has; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).enterHas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).exitHas(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlGrammarVisitor ) return ((SqlGrammarVisitor<? extends T>)visitor).visitHas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HasContext has() throws RecognitionException {
		HasContext _localctx = new HasContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_has);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			columnName();
			setState(96);
			match(HAS_);
			setState(97);
			match(String);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode GT_() { return getToken(SqlGrammarParser.GT_, 0); }
		public LiteralValueContext literalValue() {
			return getRuleContext(LiteralValueContext.class,0);
		}
		public TerminalNode LT_() { return getToken(SqlGrammarParser.LT_, 0); }
		public TerminalNode GE_() { return getToken(SqlGrammarParser.GE_, 0); }
		public TerminalNode LE_() { return getToken(SqlGrammarParser.LE_, 0); }
		public TerminalNode NE_() { return getToken(SqlGrammarParser.NE_, 0); }
		public TerminalNode EQ_() { return getToken(SqlGrammarParser.EQ_, 0); }
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlGrammarVisitor ) return ((SqlGrammarVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_comparison);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				columnName();
				setState(100);
				match(GT_);
				setState(101);
				literalValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				columnName();
				setState(104);
				match(LT_);
				setState(105);
				literalValue();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				columnName();
				setState(108);
				match(GE_);
				setState(109);
				literalValue();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(111);
				columnName();
				setState(112);
				match(LE_);
				setState(113);
				literalValue();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
				columnName();
				setState(116);
				match(NE_);
				setState(117);
				literalValue();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(119);
				columnName();
				setState(120);
				match(EQ_);
				setState(121);
				literalValue();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValidationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlGrammarParser.IDENTIFIER, 0); }
		public TerminalNode LP_() { return getToken(SqlGrammarParser.LP_, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode RP_() { return getToken(SqlGrammarParser.RP_, 0); }
		public ValidationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_validation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).enterValidation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).exitValidation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlGrammarVisitor ) return ((SqlGrammarVisitor<? extends T>)visitor).visitValidation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValidationContext validation() throws RecognitionException {
		ValidationContext _localctx = new ValidationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_validation);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(IDENTIFIER);
				{
				setState(126);
				match(LP_);
				setState(127);
				argList();
				setState(128);
				match(RP_);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(IDENTIFIER);
				{
				setState(131);
				match(LP_);
				setState(132);
				match(RP_);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlGrammarParser.IDENTIFIER, 0); }
		public TerminalNode LP_() { return getToken(SqlGrammarParser.LP_, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode RP_() { return getToken(SqlGrammarParser.RP_, 0); }
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).exitFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlGrammarVisitor ) return ((SqlGrammarVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_funcCall);
		try {
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(IDENTIFIER);
				{
				setState(136);
				match(LP_);
				setState(137);
				argList();
				setState(138);
				match(RP_);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				match(IDENTIFIER);
				{
				setState(141);
				match(LP_);
				setState(142);
				match(RP_);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgListContext extends ParserRuleContext {
		public List<MethodArgContext> methodArg() {
			return getRuleContexts(MethodArgContext.class);
		}
		public MethodArgContext methodArg(int i) {
			return getRuleContext(MethodArgContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlGrammarParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).exitArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlGrammarVisitor ) return ((SqlGrammarVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			methodArg();
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(146);
				match(COMMA);
				setState(147);
				methodArg();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodArgContext extends ParserRuleContext {
		public LiteralValueContext literalValue() {
			return getRuleContext(LiteralValueContext.class,0);
		}
		public ObjectPropertyContext objectProperty() {
			return getRuleContext(ObjectPropertyContext.class,0);
		}
		public MethodArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).enterMethodArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).exitMethodArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlGrammarVisitor ) return ((SqlGrammarVisitor<? extends T>)visitor).visitMethodArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodArgContext methodArg() throws RecognitionException {
		MethodArgContext _localctx = new MethodArgContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_methodArg);
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE_:
			case FALSE_:
			case NULL_:
			case ISO_DATE:
			case ISO_DATE_TIME:
			case Number:
			case String:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				literalValue();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				objectProperty();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectPropertyContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SqlGrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SqlGrammarParser.IDENTIFIER, i);
		}
		public List<TerminalNode> DOT() { return getTokens(SqlGrammarParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SqlGrammarParser.DOT, i);
		}
		public ObjectPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).enterObjectProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlGrammarListener ) ((SqlGrammarListener)listener).exitObjectProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlGrammarVisitor ) return ((SqlGrammarVisitor<? extends T>)visitor).visitObjectProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectPropertyContext objectProperty() throws RecognitionException {
		ObjectPropertyContext _localctx = new ObjectPropertyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_objectProperty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(IDENTIFIER);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(158);
				match(DOT);
				setState(159);
				match(IDENTIFIER);
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00a8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\2\3\2\5\2(\n\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\7\5\62\n\5\f\5\16"+
		"\5\65\13\5\3\6\3\6\3\6\7\6:\n\6\f\6\16\6=\13\6\3\7\5\7@\n\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bO\n\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\7\tW\n\t\f\t\16\tZ\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f~\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\5\r\u0088\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0092"+
		"\n\16\3\17\3\17\3\17\7\17\u0097\n\17\f\17\16\17\u009a\13\17\3\20\3\20"+
		"\5\20\u009e\n\20\3\21\3\21\3\21\7\21\u00a3\n\21\f\21\16\21\u00a6\13\21"+
		"\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\3\4\2\22\24\26"+
		"\31\2\u00ae\2\'\3\2\2\2\4)\3\2\2\2\6+\3\2\2\2\b.\3\2\2\2\n\66\3\2\2\2"+
		"\f?\3\2\2\2\16N\3\2\2\2\20P\3\2\2\2\22]\3\2\2\2\24a\3\2\2\2\26}\3\2\2"+
		"\2\30\u0087\3\2\2\2\32\u0091\3\2\2\2\34\u0093\3\2\2\2\36\u009d\3\2\2\2"+
		" \u009f\3\2\2\2\"(\7\25\2\2#$\7\3\2\2$%\7\25\2\2%(\7\3\2\2&(\5\32\16\2"+
		"\'\"\3\2\2\2\'#\3\2\2\2\'&\3\2\2\2(\3\3\2\2\2)*\t\2\2\2*\5\3\2\2\2+,\5"+
		"\b\5\2,-\7\2\2\3-\7\3\2\2\2.\63\5\n\6\2/\60\7\4\2\2\60\62\5\n\6\2\61/"+
		"\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\t\3\2\2\2\65\63"+
		"\3\2\2\2\66;\5\f\7\2\678\7\5\2\28:\5\f\7\29\67\3\2\2\2:=\3\2\2\2;9\3\2"+
		"\2\2;<\3\2\2\2<\13\3\2\2\2=;\3\2\2\2>@\7\6\2\2?>\3\2\2\2?@\3\2\2\2@A\3"+
		"\2\2\2AB\5\16\b\2B\r\3\2\2\2CO\5\20\t\2DO\5\22\n\2EO\5\24\13\2FO\5\26"+
		"\f\2GO\7\22\2\2HO\7\23\2\2IO\5\30\r\2JK\7\20\2\2KL\5\b\5\2LM\7\21\2\2"+
		"MO\3\2\2\2NC\3\2\2\2ND\3\2\2\2NE\3\2\2\2NF\3\2\2\2NG\3\2\2\2NH\3\2\2\2"+
		"NI\3\2\2\2NJ\3\2\2\2O\17\3\2\2\2PQ\5\2\2\2QR\7\7\2\2RS\7\20\2\2SX\5\4"+
		"\3\2TU\7\32\2\2UW\5\4\3\2VT\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3"+
		"\2\2\2ZX\3\2\2\2[\\\7\21\2\2\\\21\3\2\2\2]^\5\2\2\2^_\7\t\2\2_`\7\31\2"+
		"\2`\23\3\2\2\2ab\5\2\2\2bc\7\b\2\2cd\7\31\2\2d\25\3\2\2\2ef\5\2\2\2fg"+
		"\7\n\2\2gh\5\4\3\2h~\3\2\2\2ij\5\2\2\2jk\7\13\2\2kl\5\4\3\2l~\3\2\2\2"+
		"mn\5\2\2\2no\7\f\2\2op\5\4\3\2p~\3\2\2\2qr\5\2\2\2rs\7\r\2\2st\5\4\3\2"+
		"t~\3\2\2\2uv\5\2\2\2vw\7\16\2\2wx\5\4\3\2x~\3\2\2\2yz\5\2\2\2z{\7\17\2"+
		"\2{|\5\4\3\2|~\3\2\2\2}e\3\2\2\2}i\3\2\2\2}m\3\2\2\2}q\3\2\2\2}u\3\2\2"+
		"\2}y\3\2\2\2~\27\3\2\2\2\177\u0080\7\25\2\2\u0080\u0081\7\20\2\2\u0081"+
		"\u0082\5\34\17\2\u0082\u0083\7\21\2\2\u0083\u0088\3\2\2\2\u0084\u0085"+
		"\7\25\2\2\u0085\u0086\7\20\2\2\u0086\u0088\7\21\2\2\u0087\177\3\2\2\2"+
		"\u0087\u0084\3\2\2\2\u0088\31\3\2\2\2\u0089\u008a\7\25\2\2\u008a\u008b"+
		"\7\20\2\2\u008b\u008c\5\34\17\2\u008c\u008d\7\21\2\2\u008d\u0092\3\2\2"+
		"\2\u008e\u008f\7\25\2\2\u008f\u0090\7\20\2\2\u0090\u0092\7\21\2\2\u0091"+
		"\u0089\3\2\2\2\u0091\u008e\3\2\2\2\u0092\33\3\2\2\2\u0093\u0098\5\36\20"+
		"\2\u0094\u0095\7\32\2\2\u0095\u0097\5\36\20\2\u0096\u0094\3\2\2\2\u0097"+
		"\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\35\3\2\2"+
		"\2\u009a\u0098\3\2\2\2\u009b\u009e\5\4\3\2\u009c\u009e\5 \21\2\u009d\u009b"+
		"\3\2\2\2\u009d\u009c\3\2\2\2\u009e\37\3\2\2\2\u009f\u00a4\7\25\2\2\u00a0"+
		"\u00a1\7\33\2\2\u00a1\u00a3\7\25\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a6\3"+
		"\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5!\3\2\2\2\u00a6\u00a4"+
		"\3\2\2\2\16\'\63;?NX}\u0087\u0091\u0098\u009d\u00a4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}