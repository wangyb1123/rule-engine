package com.everest.rule.parser;

import java.time.LocalDate;
import java.util.function.Predicate;

public class LessThanOrEqualPredicate<T> implements Predicate<T> {

    private final Object value;

    public LessThanOrEqualPredicate(Object value) {
        super();
        this.value = value;
    }

    @Override
    public boolean test(T object) {
        if (object instanceof Long) {
            return (Long) object <= (Long) value;
        } else if (object instanceof Double) {
            return (Double) object <= (Double) value;
        } else if (object instanceof LocalDate) {
            return ((LocalDate) object).compareTo((LocalDate) value) <= 0;
        } else {
            throw new UnsupportedOperationException(
                    "GreaterThan is not supported on: " + object.getClass());
        }
    }

}
