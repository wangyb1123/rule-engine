package com.everest.rule.wrapper;

public class ObjectWrapper<T> implements Wrapper<T> {
    
    public static final String OBJECT_NAME = "wrapped";
    private final T wrapped;
    
    public ObjectWrapper(T wrapped) {
        this.wrapped = wrapped;
    }
    
    @Override
    public T getWrapped() {
        return wrapped;
    }

    @Override
    public String toString() {
        return "ObjectWrapper [wrapped=" + wrapped + "]";
    }

}
