package com.everest.rule.parser;

import com.everest.rule.wrapper.Wrapper;

public abstract class Filter<T> {
    private final T filter;
    
    public Filter(T filter) {
        this.filter = filter;
    }
    
    
    public T get() {
        return filter;
    }
    
    public abstract boolean evaluate(Wrapper object) throws Exception;


    @Override
    public String toString() {
        return "Filter [filter=" + filter + "]";
    }
    
    
}
