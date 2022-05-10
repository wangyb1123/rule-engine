package com.everest.rule.parser;

import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.everest.rule.wrapper.ObjectWrapper;
import com.everest.rule.wrapper.Wrapper;

public class BeanFilter extends Filter<Predicate<Wrapper>> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanFilter.class);
    
    public BeanFilter(Predicate<Wrapper> filter) {
        super(filter);
    }

    @Override
    public boolean evaluate(Wrapper object) throws Exception {
        return this.get().test(object);
    }
    
    public boolean evaluate(Object object) throws Exception {
        return evaluate(new ObjectWrapper(object));
    }

    @Override
    public String toString() {
        return "BeanFilter [toString()=" + super.toString() + "]";
    }

}
