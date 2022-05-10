package com.everest.rule;

public interface Attribute<T, R> {
    R execute(T t);

}
