package com.everest.rule.domain;

import com.everest.rule.RuleEngineException;
import com.everest.rule.command.RuleCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAndSkipException implements ExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAndSkipException.class);
    @Override
    public void handleOnRuleCommandException(RuleCommand command, Object object, Throwable e) throws RuleEngineException {
        LOGGER.warn("Command {} is skipped due to exception while evaluating object {}", command, object, e);
    }

    @Override
    public void handleOnRuleEvaluationException(AbstractCriteria criteria, Object object, Throwable e) throws RuleEngineException {
        LOGGER.warn("Rule {} is skipped due to exception while evaluating object {}", criteria, object, e);
    }
}
