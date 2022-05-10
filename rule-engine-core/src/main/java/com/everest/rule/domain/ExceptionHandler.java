package com.everest.rule.domain;

import com.everest.rule.RuleEngineException;
import com.everest.rule.command.RuleCommand;
import com.everest.rule.wrapper.ObjectWrapper;

public interface ExceptionHandler {
    void handleOnRuleCommandException(RuleCommand command, Object object, Throwable e) throws RuleEngineException;
    void handleOnRuleEvaluationException(AbstractCriteria criteria, Object object, Throwable e) throws RuleEngineException;
}
