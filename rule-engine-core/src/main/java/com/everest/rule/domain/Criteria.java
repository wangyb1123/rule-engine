package com.everest.rule.domain;

import com.everest.rule.RuleEngineException;
import com.everest.rule.wrapper.Wrapper;

public interface Criteria<T> {

    Boolean evaluate(Wrapper<T> t) throws RuleEngineException;

}
