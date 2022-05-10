// Generated from E:\JavaWorks\rule-engine\rule-engine-core/src/main/resources/grammar/SqlGrammar.g4 by ANTLR 4.7.2
package com.everest.rule.sql.expr.parser.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, OR_=2, AND_=3, NOT_=4, IN_=5, HAS_=6, LIKE_=7, GT_=8, LT_=9, GE_=10, 
		LE_=11, NE_=12, EQ_=13, LP_=14, RP_=15, TRUE_=16, FALSE_=17, NULL_=18, 
		IDENTIFIER=19, ISO_DATE=20, ISO_DATE_TIME=21, Number=22, String=23, COMMA=24, 
		DOT=25, SPACE=26, WHITESPACES=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "OR_", "AND_", "NOT_", "IN_", "HAS_", "LIKE_", "GT_", "LT_", 
			"GE_", "LE_", "NE_", "EQ_", "LP_", "RP_", "TRUE_", "FALSE_", "NULL_", 
			"IDENTIFIER", "DIGIT", "ISO_DATE", "ISO_DATE_TIME", "Number", "String", 
			"COMMA", "DOT", "SPACE", "WHITESPACES"
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


	public SqlGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SqlGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u0120\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\5\3B\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4J\n\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5"+
		"R\n\5\3\6\3\6\3\6\3\6\5\6X\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7p\n\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\bz\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u0097\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u00a3\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u00ad\n\23\3\24\5\24\u00b0\n\24\3\24\7\24\u00b3\n\24\f\24\16\24\u00b6"+
		"\13\24\3\24\3\24\6\24\u00ba\n\24\r\24\16\24\u00bb\3\24\5\24\u00bf\n\24"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\6\30\u00fe\n\30\r\30\16\30\u00ff\3\30\3\30\6"+
		"\30\u0104\n\30\r\30\16\30\u0105\5\30\u0108\n\30\3\31\3\31\7\31\u010c\n"+
		"\31\f\31\16\31\u010f\13\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\35\2\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\2+\26"+
		"-\27/\30\61\31\63\32\65\33\67\349\35\3\2\7\5\2C\\aac|\7\2\60\60\62;C\\"+
		"aac|\3\2bb\3\2\62;\3\2))\2\u0130\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\3;\3\2\2\2\5A\3\2\2\2\7I\3\2\2\2\tQ\3\2\2\2\13W\3\2\2"+
		"\2\ro\3\2\2\2\17y\3\2\2\2\21{\3\2\2\2\23}\3\2\2\2\25\177\3\2\2\2\27\u0082"+
		"\3\2\2\2\31\u0085\3\2\2\2\33\u0088\3\2\2\2\35\u008a\3\2\2\2\37\u008c\3"+
		"\2\2\2!\u0096\3\2\2\2#\u00a2\3\2\2\2%\u00ac\3\2\2\2\'\u00be\3\2\2\2)\u00c0"+
		"\3\2\2\2+\u00c2\3\2\2\2-\u00d8\3\2\2\2/\u00fd\3\2\2\2\61\u0109\3\2\2\2"+
		"\63\u0112\3\2\2\2\65\u0114\3\2\2\2\67\u0116\3\2\2\29\u011a\3\2\2\2;<\7"+
		"%\2\2<\4\3\2\2\2=>\7Q\2\2>B\7T\2\2?@\7q\2\2@B\7t\2\2A=\3\2\2\2A?\3\2\2"+
		"\2B\6\3\2\2\2CD\7C\2\2DE\7P\2\2EJ\7F\2\2FG\7c\2\2GH\7p\2\2HJ\7f\2\2IC"+
		"\3\2\2\2IF\3\2\2\2J\b\3\2\2\2KL\7P\2\2LM\7Q\2\2MR\7V\2\2NO\7p\2\2OP\7"+
		"q\2\2PR\7v\2\2QK\3\2\2\2QN\3\2\2\2R\n\3\2\2\2ST\7K\2\2TX\7P\2\2UV\7k\2"+
		"\2VX\7p\2\2WS\3\2\2\2WU\3\2\2\2X\f\3\2\2\2YZ\7J\2\2Z[\7C\2\2[p\7U\2\2"+
		"\\]\7j\2\2]^\7c\2\2^p\7u\2\2_`\7E\2\2`a\7Q\2\2ab\7P\2\2bc\7V\2\2cd\7C"+
		"\2\2de\7K\2\2ef\7P\2\2fp\7U\2\2gh\7e\2\2hi\7q\2\2ij\7p\2\2jk\7v\2\2kl"+
		"\7c\2\2lm\7k\2\2mn\7p\2\2np\7u\2\2oY\3\2\2\2o\\\3\2\2\2o_\3\2\2\2og\3"+
		"\2\2\2p\16\3\2\2\2qr\7N\2\2rs\7K\2\2st\7M\2\2tz\7G\2\2uv\7n\2\2vw\7k\2"+
		"\2wx\7m\2\2xz\7g\2\2yq\3\2\2\2yu\3\2\2\2z\20\3\2\2\2{|\7@\2\2|\22\3\2"+
		"\2\2}~\7>\2\2~\24\3\2\2\2\177\u0080\7@\2\2\u0080\u0081\7?\2\2\u0081\26"+
		"\3\2\2\2\u0082\u0083\7>\2\2\u0083\u0084\7?\2\2\u0084\30\3\2\2\2\u0085"+
		"\u0086\7>\2\2\u0086\u0087\7@\2\2\u0087\32\3\2\2\2\u0088\u0089\7?\2\2\u0089"+
		"\34\3\2\2\2\u008a\u008b\7*\2\2\u008b\36\3\2\2\2\u008c\u008d\7+\2\2\u008d"+
		" \3\2\2\2\u008e\u008f\7V\2\2\u008f\u0090\7T\2\2\u0090\u0091\7W\2\2\u0091"+
		"\u0097\7G\2\2\u0092\u0093\7v\2\2\u0093\u0094\7t\2\2\u0094\u0095\7w\2\2"+
		"\u0095\u0097\7g\2\2\u0096\u008e\3\2\2\2\u0096\u0092\3\2\2\2\u0097\"\3"+
		"\2\2\2\u0098\u0099\7H\2\2\u0099\u009a\7C\2\2\u009a\u009b\7N\2\2\u009b"+
		"\u009c\7U\2\2\u009c\u00a3\7G\2\2\u009d\u009e\7h\2\2\u009e\u009f\7c\2\2"+
		"\u009f\u00a0\7n\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a3\7g\2\2\u00a2\u0098"+
		"\3\2\2\2\u00a2\u009d\3\2\2\2\u00a3$\3\2\2\2\u00a4\u00a5\7P\2\2\u00a5\u00a6"+
		"\7W\2\2\u00a6\u00a7\7N\2\2\u00a7\u00ad\7N\2\2\u00a8\u00a9\7p\2\2\u00a9"+
		"\u00aa\7w\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ad\7n\2\2\u00ac\u00a4\3\2\2"+
		"\2\u00ac\u00a8\3\2\2\2\u00ad&\3\2\2\2\u00ae\u00b0\t\2\2\2\u00af\u00ae"+
		"\3\2\2\2\u00b0\u00b4\3\2\2\2\u00b1\u00b3\t\3\2\2\u00b2\u00b1\3\2\2\2\u00b3"+
		"\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00bf\3\2"+
		"\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b9\7b\2\2\u00b8\u00ba\n\4\2\2\u00b9"+
		"\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2"+
		"\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\7b\2\2\u00be\u00af\3\2\2\2\u00be"+
		"\u00b7\3\2\2\2\u00bf(\3\2\2\2\u00c0\u00c1\t\5\2\2\u00c1*\3\2\2\2\u00c2"+
		"\u00c3\7K\2\2\u00c3\u00c4\7U\2\2\u00c4\u00c5\7Q\2\2\u00c5\u00c6\7a\2\2"+
		"\u00c6\u00c7\7F\2\2\u00c7\u00c8\7C\2\2\u00c8\u00c9\7V\2\2\u00c9\u00ca"+
		"\7G\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\7*\2\2\u00cc\u00cd\5)\25\2\u00cd"+
		"\u00ce\5)\25\2\u00ce\u00cf\5)\25\2\u00cf\u00d0\5)\25\2\u00d0\u00d1\7/"+
		"\2\2\u00d1\u00d2\5)\25\2\u00d2\u00d3\5)\25\2\u00d3\u00d4\7/\2\2\u00d4"+
		"\u00d5\5)\25\2\u00d5\u00d6\5)\25\2\u00d6\u00d7\7+\2\2\u00d7,\3\2\2\2\u00d8"+
		"\u00d9\7K\2\2\u00d9\u00da\7U\2\2\u00da\u00db\7Q\2\2\u00db\u00dc\7a\2\2"+
		"\u00dc\u00dd\7F\2\2\u00dd\u00de\7C\2\2\u00de\u00df\7V\2\2\u00df\u00e0"+
		"\7G\2\2\u00e0\u00e1\7a\2\2\u00e1\u00e2\7V\2\2\u00e2\u00e3\7K\2\2\u00e3"+
		"\u00e4\7O\2\2\u00e4\u00e5\7G\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\7*\2"+
		"\2\u00e7\u00e8\5)\25\2\u00e8\u00e9\5)\25\2\u00e9\u00ea\5)\25\2\u00ea\u00eb"+
		"\5)\25\2\u00eb\u00ec\7/\2\2\u00ec\u00ed\5)\25\2\u00ed\u00ee\5)\25\2\u00ee"+
		"\u00ef\7/\2\2\u00ef\u00f0\5)\25\2\u00f0\u00f1\5)\25\2\u00f1\u00f2\7V\2"+
		"\2\u00f2\u00f3\5)\25\2\u00f3\u00f4\5)\25\2\u00f4\u00f5\7<\2\2\u00f5\u00f6"+
		"\5)\25\2\u00f6\u00f7\5)\25\2\u00f7\u00f8\7<\2\2\u00f8\u00f9\5)\25\2\u00f9"+
		"\u00fa\5)\25\2\u00fa\u00fb\7+\2\2\u00fb.\3\2\2\2\u00fc\u00fe\5)\25\2\u00fd"+
		"\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2"+
		"\2\2\u0100\u0107\3\2\2\2\u0101\u0103\7\60\2\2\u0102\u0104\5)\25\2\u0103"+
		"\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106\u0108\3\2\2\2\u0107\u0101\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"\60\3\2\2\2\u0109\u010d\7)\2\2\u010a\u010c\n\6\2\2\u010b\u010a\3\2\2\2"+
		"\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110"+
		"\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111\7)\2\2\u0111\62\3\2\2\2\u0112"+
		"\u0113\7.\2\2\u0113\64\3\2\2\2\u0114\u0115\7\60\2\2\u0115\66\3\2\2\2\u0116"+
		"\u0117\7\"\2\2\u0117\u0118\3\2\2\2\u0118\u0119\b\34\2\2\u01198\3\2\2\2"+
		"\u011a\u011b\7\f\2\2\u011b\u011c\7\17\2\2\u011c\u011d\7\13\2\2\u011d\u011e"+
		"\3\2\2\2\u011e\u011f\b\35\2\2\u011f:\3\2\2\2\25\2AIQWoy\u0096\u00a2\u00ac"+
		"\u00af\u00b2\u00b4\u00bb\u00be\u00ff\u0105\u0107\u010d\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}