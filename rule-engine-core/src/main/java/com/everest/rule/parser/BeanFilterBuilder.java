package com.everest.rule.parser;

import com.everest.rule.RuleContext;
import com.google.common.base.Predicates;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BeanFilterBuilder implements StringFilterBuilder<BeanFilter> {
    private Predicate customizedFilter;

    public static BeanFilterBuilder newInstance() {
        return new BeanFilterBuilder();
    }
    @Override
    public BeanFilter customizedFilter(String path, List<?> values, FilterOperator operator, RuleContext ruleContext) {
        switch(operator){
            case EQUALS:
                customizedFilter = new AttributeAwareBeanPredicate<>(path, Predicate.isEqual(values.get(0)), ruleContext);
                break;
            case NOT_EQUALS:
                customizedFilter = new AttributeAwareBeanPredicate(path, Predicate.not(Predicate.isEqual(values.get(0))), ruleContext);
                break;
            case GREATER_THAN:
                customizedFilter = new AttributeAwareBeanPredicate<>(path, new GreaterThanPredicate<>(values.get(0)), ruleContext);
                break;
            case GREAT_THAN_OR_EQUALS:
                customizedFilter = new AttributeAwareBeanPredicate<>(path, new GreaterThanOrEqualPredicate<>(values.get(0)), ruleContext);
                break;
            case IN:
                customizedFilter = new AttributeAwareBeanPredicate<>(path, new InPredicate<>(values), ruleContext);
                break;
            case LESS_THAN:
                customizedFilter = new AttributeAwareBeanPredicate<>(path, new LessThanPredicate<>(values.get(0)), ruleContext);
                break;
            case LESS_THAN_OR_EQUALS:
                customizedFilter = new AttributeAwareBeanPredicate<>(path, new LessThanOrEqualPredicate<>(values.get(0)), ruleContext);
                break;
            case LIKE:
                customizedFilter = new AttributeAwareBeanPredicate<>(path, new LikePredicate<>((String) values.get(0)), ruleContext);
                break;
            case HAS:
                customizedFilter = new AttributeAwareBeanPredicate<>(path, new ContainsPredicate<>((String) values.get(0)), ruleContext);
                break;
            default:
                break;
        }
        return new BeanFilter(customizedFilter);
    }

    @Override
    public BeanFilter and(BeanFilter... filters) {
        return and(Arrays.asList(filters));
    }

    @Override
    public BeanFilter and(List<BeanFilter> filters) {
        customizedFilter = new AllPredicate(filters.stream().map(e -> e.get()).collect(Collectors.toList()));
        return new BeanFilter(customizedFilter);
    }

    @Override
    public BeanFilter or(BeanFilter[] filters) {
        return or(Arrays.asList(filters));
    }

    @Override
    public BeanFilter or(List<BeanFilter> filters) {
        customizedFilter = new AnyPredicate(filters.stream().map(e -> e.get()).collect(Collectors.toList()));
        return new BeanFilter(customizedFilter);
    }

    @Override
    public BeanFilter not(BeanFilter filter) {
        customizedFilter = Predicate.not(filter.get());
        return new BeanFilter(customizedFilter);
    }

    @Override
    public BeanFilter validation(String methodName, List<?> args) {
        customizedFilter = new ValidationPredicate(methodName, args);
        return new BeanFilter(customizedFilter);
    }

    @Override
    public BeanFilter alwaysTrue() {
        customizedFilter = Predicates.alwaysTrue();
        return new BeanFilter(customizedFilter);
    }

    @Override
    public BeanFilter alwaysFalse() {
        customizedFilter = Predicates.alwaysFalse();
        return new BeanFilter(customizedFilter);
    }

    @Override
    public BeanFilter functionFilter(String methodName, List<?> args, List<?> values, FilterOperator operator, RuleContext ruleContext) {
        FunctionCall functionCall = new FunctionCall(ruleContext, methodName, args);
        switch(operator){
            case EQUALS:
                customizedFilter = new FunctionPredicate<>(functionCall, Predicate.isEqual(values.get(0)));
                break;
            case NOT_EQUALS:
                customizedFilter = new FunctionPredicate(functionCall, Predicate.not(Predicate.isEqual(values.get(0))));
                break;
            case GREATER_THAN:
                customizedFilter = new FunctionPredicate<>(functionCall, new GreaterThanPredicate<>(values.get(0)));
                break;
            case GREAT_THAN_OR_EQUALS:
                customizedFilter = new FunctionPredicate<>(functionCall, new GreaterThanOrEqualPredicate<>(values.get(0)));
                break;
            case IN:
                customizedFilter = new FunctionPredicate<>(functionCall, new InPredicate<>(values));
                break;
            case LESS_THAN:
                customizedFilter = new FunctionPredicate<>(functionCall, new LessThanPredicate<>(values.get(0)));
                break;
            case LESS_THAN_OR_EQUALS:
                customizedFilter = new FunctionPredicate<>(functionCall, new LessThanOrEqualPredicate<>(values.get(0)));
                break;
            case LIKE:
                customizedFilter = new FunctionPredicate<>(functionCall, new LikePredicate<>((String) values.get(0)));
                break;
            case HAS:
                customizedFilter = new FunctionPredicate<>(functionCall, new ContainsPredicate<>((String) values.get(0)));
                break;
            default:
                break;
        }
        return new BeanFilter(customizedFilter);
    }

    public Predicate getFilter(){
        return customizedFilter;
    }

    @Override
    public BeanFilter build() {
        return new BeanFilter(this.getFilter());
    }
}
