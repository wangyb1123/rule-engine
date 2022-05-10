package com.everest.rule;

import com.everest.rule.domain.AbstractCriteria;
import com.everest.rule.parser.RuleEngineParserErrorListener;
import com.everest.rule.parser.sql.ParseErrorListener;
import com.everest.rule.sql.expr.parser.generated.SqlGrammarLexer;
import com.everest.rule.sql.expr.parser.generated.SqlGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.atn.PredictionMode;

public class SqlUtils {
    public static <T> SqlGrammarParser buildParser(String sql, AbstractCriteria<T> abstractCriteria) {
        SqlGrammarLexer lexer = new SqlGrammarLexer(CharStreams.fromString(sql));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SqlGrammarParser parser = new SqlGrammarParser(tokens);
        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
//        ParseErrorListener errorListener = new ParseErrorListener(abstractCriteria);
        ParseErrorListener errorListener = new ParseErrorListener();
        parser.addErrorListener(errorListener);
        return parser;
    }

    public static <T> SqlGrammarParser buildParser(String sql, RuleEngineParserErrorListener ruleEngineParserErrorListener) {
        SqlGrammarLexer lexer = new SqlGrammarLexer(CharStreams.fromString(sql));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SqlGrammarParser parser = new SqlGrammarParser(tokens);
        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
        parser.addErrorListener(ruleEngineParserErrorListener);
        return parser;
    }
}
