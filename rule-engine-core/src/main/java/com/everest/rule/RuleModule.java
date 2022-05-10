package com.everest.rule;

import com.google.inject.AbstractModule;

import java.util.Map;

public abstract class RuleModule {
    private final String packageName;
    public RuleModule(String packageName) {
        this.packageName = packageName;
    }

    protected AbstractModule configure() {
        return new AbstractModule() {
            @Override
            protected void configure(){
                RuleModule.this.getServices().forEach((key, value) -> bind(key).toInstance(value));
            }
        };
    }

    public abstract Map<Class, Object> getServices();

    public String getPackageName() {
        return packageName;
    }
}
