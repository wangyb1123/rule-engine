package com.everest.rule.parser;

import com.everest.rule.RuleContext;
import com.everest.rule.RuleEngineException;
import com.everest.rule.RuleModule;
import com.everest.rule.wrapper.ObjectWrapper;
import com.google.common.collect.Lists;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;

public class FunctionCallTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FunctionCallTest.class);

    @Test
    public void whenMethodExistsInEvaluatedObjectShouldInvoke() throws RuleEngineException {
        TradeMock trade = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        RuleContext ruleContext = new RuleContext();
        ruleContext.register(new RuleModule("com.everest.rule.annotation") {
            @Override
            public Map<Class, Object> getServices() {
                return Collections.emptyMap();
            }
        });

        FunctionCall functionCall = new FunctionCall(ruleContext, "objectMethod", Lists.newArrayList("test_user"));
        Object result = functionCall.invoke(new ObjectWrapper(trade));
        Assert.assertThat(result, Matchers.is("test_user_objectMethod"));
    }

    @Test
    public void whenMethodExistsInServiceShouldInvoke() throws RuleEngineException {
        TradeMock trade = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        RuleContext ruleContext = new RuleContext();
        ruleContext.register(new RuleModule("com.everest.rule.annotation") {
            @Override
            public Map<Class, Object> getServices() {
                return Collections.emptyMap();
            }
        });

        FunctionCall functionCall = new FunctionCall(ruleContext, "serviceMethod1", Lists.newArrayList("test_user"));
        Object result = functionCall.invoke(new ObjectWrapper(trade));
        Assert.assertThat(result, Matchers.is("test_user_serviceMethod1"));

        functionCall = new FunctionCall(ruleContext, "serviceMethod1", Lists.newArrayList(100));
        result = functionCall.invoke(new ObjectWrapper(trade));
        Assert.assertThat(result, Matchers.is("100"));
    }

    @Test
    public void whenInvokeMethodWithPropertyShouldGetPropertyFromObject() throws RuleEngineException {
        TradeMock trade = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        RuleContext ruleContext = new RuleContext();
        ruleContext.register(new RuleModule("com.everest.rule.annotation") {
            @Override
            public Map<Class, Object> getServices() {
                return Collections.emptyMap();
            }
        });

        FunctionCall functionCall = new FunctionCall(ruleContext, "serviceMethod1", Lists.newArrayList("$book"));
        Object result = functionCall.invoke(new ObjectWrapper(trade));
        Assert.assertThat(result, Matchers.is("book_1_serviceMethod1"));
    }

    @Test
    public void whenInvokeMethodWithObjectItselfShouldInvoke() throws RuleEngineException {
        TradeMock trade = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        RuleContext ruleContext = new RuleContext();
        ruleContext.register(new RuleModule("com.everest.rule.annotation") {
            @Override
            public Map<Class, Object> getServices() {
                return Collections.emptyMap();
            }
        });

        FunctionCall functionCall = new FunctionCall(ruleContext, "functionCallWithObject", Lists.newArrayList("$it", "test_user"));
        Object result = functionCall.invoke(new ObjectWrapper(trade));
        Assert.assertThat(result, Matchers.is("test_user_functionCallWithObject_TradeMock_1"));
    }



}