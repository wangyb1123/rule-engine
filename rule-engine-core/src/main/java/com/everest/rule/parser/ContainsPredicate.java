package com.everest.rule.parser;

import java.util.Collection;
import java.util.function.Predicate;

public class ContainsPredicate<T> implements Predicate<T> {
    
    private final String value;
    
    public ContainsPredicate(String value) {
        super();
        this.value = value;
    }

    @Override
    public boolean test(T object) {
        if(object == null){
            return false;
        }
        if(object instanceof Collection){
            return ((Collection) object).contains(value);
        }else{
            return false;    
        }
    }

}
