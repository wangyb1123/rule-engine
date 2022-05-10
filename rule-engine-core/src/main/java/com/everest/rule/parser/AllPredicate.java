package com.everest.rule.parser;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class AllPredicate<T> implements Predicate<T> {

    private final List<Predicate<T>> predicates;

    public AllPredicate(List<Predicate<T>> predicates) {
        this.predicates = predicates;
    }

    @Override
    public boolean test(T object) {
        for(Iterator<Predicate<T>> i = predicates.iterator(); i.hasNext(); ){
            if (!i.next().test(object)) {
                return false;
            }
        }
        return true;
    }
}
