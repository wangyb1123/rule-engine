package com.everest.rule.domain;

import com.everest.rule.RuleEngineException;
import com.everest.rule.command.RuleCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RethrowException implements ExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RethrowException.class);
    @Override
    public void handleOnRuleCommandException(RuleCommand command, Object object, Throwable e) throws RuleEngineException {
        throw new RuleEngineException("Error in executing command " + command.toString() + " on object " + object.toString(), e);
    }

    @Override
    public void handleOnRuleEvaluationException(AbstractCriteria criteria, Object object, Throwable e) throws RuleEngineException {
        throw new RuleEngineException("Error in evaluating object " + object.toString() + ", " + criteria, e);
    }
}
