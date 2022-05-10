package com.everest.rule.parser;

import java.util.List;

import com.everest.rule.RuleContext;

public interface StringFilterBuilder<T> {
    
    T customizedFilter(String path, List<?> values, FilterOperator operator, RuleContext ruleContext);
    
    T and(T[] filters);
    
    T and(List<T> filters);
    
    T or(T[] filters);
    
    T or(List<T> filters);
    
    T not(T filter);
    
    T validation(String methodName, List<?> args);
    
    T alwaysTrue();
    
    T alwaysFalse();
    
    T functionFilter(String methodName, List<?> args, List<?> values, FilterOperator operator, RuleContext ruleContext);
    
    T build();

}
