package com.everest.rule.parser;

import com.everest.rule.RuleEngineException;
import com.everest.rule.wrapper.ObjectWrapper;
import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.function.Predicate;

public class FunctionPredicate<T> implements Predicate<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FunctionPredicate.class);

    private final FunctionCall functionCall;
    private final Predicate<T> predicate;

    public FunctionPredicate(FunctionCall functionCall, Predicate<T> predicate) {
        this.functionCall = functionCall;
        this.predicate = predicate;
    }

    @Override
    public boolean test(T object) {
        try{
            Object result = functionCall.invoke((ObjectWrapper) object);
            if(result instanceof Optional){
                result = ((Optional<?>) result).orElse(null);
            }
            return predicate.test(object);

        }catch (RuleEngineException e) {
            throw new IllegalArgumentException(String.format("Problem while invoking function %s", functionCall), e);
        }
    }

    @VisibleForTesting
    Predicate<T> getPredicate() {
        return predicate;
    }
}
