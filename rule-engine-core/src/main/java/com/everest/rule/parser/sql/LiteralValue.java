package com.everest.rule.parser.sql;

public class LiteralValue<T> {
    T value;
    
    public LiteralValue(T value) {
        super();
        this.value = value;
    }
    
    public T getValue(){
        return value;
    }

}
