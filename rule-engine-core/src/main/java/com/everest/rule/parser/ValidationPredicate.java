package com.everest.rule.parser;

import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidationPredicate<T> implements Predicate<T> {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ValidationPredicate.class);

    private final String method;
    private final List<?> args;

    public ValidationPredicate(String method, List<?> args) {
        super();
        this.method = method;
        this.args = args;
    }

    @Override
    public boolean test(T object) {
        String methodForLog = null;
        try {
            Object[] argArray = new Object[args.size()];
            for (int i = 0; i < args.size(); i++) {
                Object arg = args.get(i);
                if (arg instanceof String && ((String) arg).startsWith("$")) {
                    String argMethod = ((String) arg).substring(1);
                    methodForLog = argMethod;
                    argArray[i] = PropertyUtils.getProperty(object, argMethod);
                } else {
                    argArray[i] = args.get(i);
                }
            }
            methodForLog = method;
            LOGGER.info("Invoke method {} with parameters {}", methodForLog,
                    argArray);
            Object result = MethodUtils.invokeMethod(object, method, argArray);
            return (Boolean) result;
        } catch (Exception e) {
            LOGGER.warn("Error while invoking method {} on object {} :",
                    methodForLog, object, e);
            return false;
        }
    }

}
