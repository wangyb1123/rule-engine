package com.everest.rule.parser;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.function.Predicate;

import org.apache.commons.beanutils.PropertyUtils;

import com.everest.rule.Attribute;
import com.everest.rule.RuleContext;
import com.everest.rule.wrapper.ObjectWrapper;
import com.google.common.annotations.VisibleForTesting;

public class AttributeAwareBeanPredicate<T> implements Predicate<T> {
    
    private final String propertyName;
    private final Predicate<T> predicate;
    private final RuleContext ruleContext;
    
    public AttributeAwareBeanPredicate(String propertyName,
            Predicate<T> predicate, RuleContext ruleContext) {
        super();
        this.propertyName = propertyName;
        this.predicate = predicate;
        this.ruleContext = ruleContext;
    }



    @Override
    public boolean test(T object) {
        boolean evaluation = false;
        Attribute attribute = ruleContext.getAttribute(this.getAttributeName(propertyName));
        if(attribute != null){
            Object result = attribute.execute(((ObjectWrapper) object).getWrapped());
            if(result instanceof Optional){
                result = ((Optional)result).orElse(null);
            }
            evaluation = predicate.test((T) result);
        } else {
            
            try {
                Object propValue = PropertyUtils.getProperty(object, propertyName);
                evaluation = predicate.test((T) propValue);
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException(String.format("Unable to access the property %s provided", this.getAttributeName(propertyName)), e);
            } catch (InvocationTargetException e) {
                throw new IllegalArgumentException(String.format("Exception occured in property's getter %s", this.getAttributeName(propertyName)), e);
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException(String.format("Property %s not found", this.getAttributeName(propertyName)), e);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(String.format("Problem during evalution property %s", this.getAttributeName(propertyName)), e);
            }
            
        }
        return evaluation;
    }


    @VisibleForTesting
    Predicate<T> getPredicate() {
        return this.predicate;
    }
    
    private String getAttributeName(String propertyName) {
        return propertyName.substring(propertyName.indexOf('.')+1);
    }

}
