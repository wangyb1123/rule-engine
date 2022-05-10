package com.everest.rule.parser;

import java.util.Collection;
import java.util.function.Predicate;

public class InPredicate<T> implements Predicate<T> {

    private final Collection<T> values;

    public InPredicate(Collection<T> values) {
        super();
        this.values = values;
    }

    @Override
    public boolean test(T object) {
        return values.contains(object);
    }

}
