package com.everest.rule;

import com.everest.rule.command.ValidationResult;
import com.everest.rule.wrapper.Wrapper;

public interface Validator<T> {
    ValidationResult validate(Wrapper<T> t);
}
