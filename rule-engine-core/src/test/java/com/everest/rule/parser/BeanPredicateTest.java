package com.everest.rule.parser;

import com.google.common.base.Predicates;
import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.AndPredicate;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.OrPredicate;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class BeanPredicateTest {

    @Test
    public void testAndOr() {
        TradeMock trade = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));

        Predicate equal = new EqualPredicate("book_1");
//        Predicate equal = Predicates.equalTo("book_1");
        BeanPredicate bookPredicate = new BeanPredicate("book", equal);

        Predicate equal2 = new EqualPredicate("legal_2");
        BeanPredicate legalPredicate = new BeanPredicate("legalEntity", equal2);

        Predicate and = new AndPredicate(bookPredicate, legalPredicate);
        Predicate or = new OrPredicate(bookPredicate, legalPredicate);
        Assert.assertFalse(and.evaluate(trade));
        Assert.assertTrue(or.evaluate(trade));
    }
}
