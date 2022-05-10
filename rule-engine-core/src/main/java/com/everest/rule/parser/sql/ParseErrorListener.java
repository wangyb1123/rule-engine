package com.everest.rule.parser.sql;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ParseErrorListener extends BaseErrorListener {
    
    private List<String> error = new ArrayList<>();
    
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e){
        String errorMessage = String.format("Invalid expression: line %d:%d %s",  line, charPositionInLine, msg);
        error.add(errorMessage);
    }
    
    public List<String> getError() {
        return error;
    }

}
