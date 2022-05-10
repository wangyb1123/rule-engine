package com.everest.rule;

import com.everest.rule.annotation.RuleAttribute;
import com.everest.rule.annotation.RuleService;
import com.everest.rule.annotation.RuleValidation;
import com.google.common.collect.Maps;
import com.google.common.reflect.ClassPath;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class RuleContext {
    private static final Logger LOGGER = LoggerFactory.getLogger(RuleContext.class);
    private Map<Object, Object> parameters = Maps.newHashMap();
    private Map<String, Object> services = Maps.newHashMap();
    private Map<String, Attribute> attributes = Maps.newHashMap();
    private Map<String, Validator> validators = Maps.newHashMap();
    private Injector injector;


    public void register(RuleModule module) throws RuleEngineException {
        injector = Guice.createInjector(module.configure());
        Set<ClassPath.ClassInfo> clazzes = null;
        try {
            clazzes = ClassPath.from(Thread.currentThread().getContextClassLoader()).getTopLevelClassesRecursive(module.getPackageName());
            for (ClassPath.ClassInfo clazz : clazzes) {
                Class loaded = clazz.load();
                if (loaded.getAnnotations().length > 0) {
                    if (loaded.isAnnotationPresent(RuleService.class)) {
                        LOGGER.info("Service: {}", clazz);
                        RuleService annotation = (RuleService) loaded.getAnnotation(RuleService.class);
                        registerService(annotation.name(), injector.getInstance(loaded));
                    } else if (loaded.isAnnotationPresent(RuleAttribute.class)) {
                        LOGGER.info("Attribute: {}", clazz);
                        RuleAttribute annotation = (RuleAttribute) loaded.getAnnotation(RuleAttribute.class);
                        registerAttribute(annotation.name(), (Attribute) injector.getInstance(loaded));
                    } else if (loaded.isAnnotationPresent(RuleValidation.class)) {
                        LOGGER.info("Validation: {}", clazz);
                        RuleValidation annotation = (RuleValidation) loaded.getAnnotation(RuleValidation.class);
                        registerValidator(annotation.name(), (Validator) injector.getInstance(loaded));
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.error("Error while initializing rule engine module: {}", e);
            throw new RuleEngineException("Error while initializing rule engin module", e);
        }
    }

    public Map<String, Object> getServices() {
        return services;
    }

    public Object getService(String name) {
        return services.get(name);
    }

    public Attribute getAttribute(String name) {
        return attributes.get(name);
    }

    public Validator getValidator(String name) {
        return validators.get(name);
    }

    public Object get(Object key) {
        return parameters.get(key);
    }

    public void put(Object key, Object value) {
        parameters.put(key, value);
    }

    private void registerService(String name, Object service) {
        services.put(name, service);
    }

    private void registerAttribute(String name, Attribute attribute) {
        attributes.put(name, attribute);
    }

    private void registerValidator(String name, Validator validator) {
        validators.put(name, validator);
    }

    public Map<String, Validator> getValidators() {
        return validators;
    }

    @Override
    public String toString() {
        return "RuleContext{" +
                "parameters=" + parameters +
                ", services=" + services +
                ", attributes=" + attributes +
                ", validators=" + validators +
                ", injector=" + injector +
                '}';
    }
}
