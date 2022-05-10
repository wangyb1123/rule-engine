package com.everest.rule.parser;

import com.everest.rule.RuleContext;
import com.everest.rule.RuleEngineException;
import com.everest.rule.wrapper.ObjectWrapper;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class FunctionCall {
    private static final Logger LOGGER = LoggerFactory.getLogger(FunctionCall.class);

    public static final String ATTRIBUTE_PREFIX = "$";
    public static final String EVALUATED_OBJECT = "$it";

    private final RuleContext ruleContext;
    private final String method;
    private final List<?> args;


    public FunctionCall(RuleContext ruleContext, String method, List<?> args) {
        this.ruleContext = ruleContext;
        this.method = method;
        this.args = args;
    }

    public Object invoke(ObjectWrapper object) throws RuleEngineException {
        String argMethod = null;
        Object[] argArray = new Object[args.size()];
        try {
            for (int i = 0; i < args.size(); i++) {
                Object arg = args.get(i);
                if (arg instanceof String && EVALUATED_OBJECT.equals(arg)) {
                    argArray[i] = object.getWrapped();
                } else if (arg instanceof String && ((String) arg).startsWith(ATTRIBUTE_PREFIX)) {
                    argMethod = ((String) arg).substring(1);
                    argArray[i] = PropertyUtils.getProperty(object.getWrapped(), argMethod);
                } else {
                    argArray[i] = args.get(i);
                }
            }

        } catch (Exception e) {
            LOGGER.error("Error while getting attribute {} from object {} : {}", argMethod, object.getWrapped(), e);
            throw new RuleEngineException(e);
        }
        //get arguments type
        final int arguments = argArray.length;
        final Class<?>[] parameterTypes = new Class[arguments];
        for (int i = 0; i < arguments; i++) {
            parameterTypes[i] = argArray[i].getClass();
        }

        //invoke method on evaluated object if it exists
        try {
            Method objectFunction = MethodUtils.getMatchingAccessibleMethod(object.getWrapped().getClass(), method, parameterTypes);
            if (objectFunction != null) {

                return objectFunction.invoke(object.getWrapped(), argArray);

            }
        } catch (Exception e) {
            LOGGER.error("Error while invoking method {} on evaluated object {} : {}", method, object, e);
        }
        //invoke method on service if it exists
        for (Object service : ruleContext.getServices().values()) {
            Method function = MethodUtils.getMatchingAccessibleMethod(service.getClass(), method, parameterTypes);
            if (function != null) {
                try {
                    return function.invoke(service, argArray);
                } catch (Exception e) {
                    LOGGER.error("Error while invoking method {} on service {} : {}", method, service, e);
                }
            }
        }
        throw new RuleEngineException(String.format("Method %s is not found in rule context", method));
    }

    @Override
    public String toString() {
        return "FunctionCall{" +
                "ruleContext=" + ruleContext +
                ", method='" + method + '\'' +
                ", args=" + args +
                '}';
    }
}
