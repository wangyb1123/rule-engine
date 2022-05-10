package com.everest.rule.parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import com.everest.rule.domain.AbstractCriteria;

public class RuleEngineParserErrorListener extends BaseErrorListener {
    
    private final AbstractCriteria criteria;
    
    public RuleEngineParserErrorListener(AbstractCriteria criteria) {
        super();
        this.criteria = criteria;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e){
        String error = String.format("Invalid filter: %s, parse error (line=%d/column=%d): %s",  criteria, line, charPositionInLine, msg);
        throw new ParseCancellationException(error);
    }

}
