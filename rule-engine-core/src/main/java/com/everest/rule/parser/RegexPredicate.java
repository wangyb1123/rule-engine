package com.everest.rule.parser;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPredicate<T> implements Predicate<T> {

    private String regex;
    private Pattern pattern;

    public RegexPredicate(String regex) {
        super();
        this.regex = regex;
    }

    @Override
    public boolean test(T object) {
        String value = (String) object;
        if (value == null) {
            return (regex == null);
        } else if (regex == null) {
            return false;
        } else {
            if (pattern == null) {
                pattern = Pattern.compile(regex);
            }
            Matcher m = pattern.matcher(value);
            return m.matches();
        }
    }

}
