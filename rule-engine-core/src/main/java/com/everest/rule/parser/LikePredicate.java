package com.everest.rule.parser;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class LikePredicate<T> implements Predicate<T> {

    private final String regex;
    private final Pattern pattern;

    public LikePredicate(String regex) {
        super();
        // TODO: check not null
        this.regex = regex.replaceAll("%", ".*");
        this.pattern = Pattern.compile(this.regex);
    }

    @Override
    public boolean test(T object) {
        return pattern.matcher((String) object).matches();
    }

}
