package com.everest.rule.parser;

import com.everest.rule.RuleContext;
import com.everest.rule.RuleModule;
import com.everest.rule.domain.AbstractCriteria;
import com.everest.rule.parser.sql.ParseErrorListener;
import com.everest.rule.parser.sql.SqlVisitor;
import com.everest.rule.sql.expr.parser.generated.SqlGrammarLexer;
import com.everest.rule.sql.expr.parser.generated.SqlGrammarParser;
import com.google.common.collect.Lists;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class ParserTest {

    private RuleContext ruleContext;

    @Before
    public void setUp() throws Exception {
        ruleContext = new RuleContext();
        ruleContext.register(new RuleModule("com.everest.rule.annotation") {

            @Override
            public Map<Class, Object> getServices() {
                return Collections.emptyMap();
            }
        });
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void whenTrueShouldReturnTrueFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 17));

        String sql = "true";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
        Assert.assertTrue(predicate.evaluate(trade3));

        sql = "TRUE";
        predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
        Assert.assertTrue(predicate.evaluate(trade3));
    }

    @Test
    public void whenFalseShouldReturnFalseFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 17));

        String sql = "false";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
        Assert.assertFalse(predicate.evaluate(trade2));
        Assert.assertFalse(predicate.evaluate(trade3));

        sql = "FALSE";
        predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
        Assert.assertFalse(predicate.evaluate(trade2));
        Assert.assertFalse(predicate.evaluate(trade3));
    }

    @Test
    public void whenEqualShouldReturnEqualFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 17));
        String sql = "book = 'book_1'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertFalse(predicate.evaluate(trade2));
        Assert.assertFalse(predicate.evaluate(trade3));
    }

    @Test
    public void whenNotEqualShouldReturnNotEqualFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 17));
        String sql = "book <> 'book_1'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
        Assert.assertTrue(predicate.evaluate(trade3));
    }

    @Test
    public void whenNumericEqualShouldReturnNumericEqualFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 17));
        String sql = "id = 2";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
        Assert.assertFalse(predicate.evaluate(trade3));
    }

    @Test
    public void whenNotNumericEqualShouldReturnNotNumericEqualFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 17));
        String sql = "id <> 2";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertFalse(predicate.evaluate(trade2));
        Assert.assertTrue(predicate.evaluate(trade3));
    }

    @Test
    public void whenDateEqualShouldReturnDateEqualFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 16));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 18));
        String sql = "maturityDate = ISO_DATE(2019-04-17)";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
        Assert.assertFalse(predicate.evaluate(trade3));
    }

    @Test
    public void whenGreaterThanShouldReturnGreaterThanFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 17));
        String sql = "id > 2";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
        Assert.assertFalse(predicate.evaluate(trade2));
        Assert.assertTrue(predicate.evaluate(trade3));
    }

    @Test
    public void whenGreaterThanOrEqualShouldReturnGreaterThanOrEqualFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 17));
        String sql = "id >= 2";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
        Assert.assertTrue(predicate.evaluate(trade3));
    }

    @Test
    public void whenLessThanShouldReturnLessThanFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 17));
        String sql = "id < 2";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertFalse(predicate.evaluate(trade2));
        Assert.assertFalse(predicate.evaluate(trade3));
    }

    @Test
    public void whenLessThanOrEqualShouldReturnLessThanOrEqualFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 17));
        String sql = "id <= 2";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
        Assert.assertFalse(predicate.evaluate(trade3));
    }

    @Test
    public void whenDateGreaterThanShouldReturnDateGreaterThanFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 16));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 18));
        String sql = "maturityDate > ISO_DATE(2019-04-17)";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
        Assert.assertFalse(predicate.evaluate(trade2));
        Assert.assertTrue(predicate.evaluate(trade3));
    }

    @Test
    public void whenDateGreaterThanEqualShouldReturnDateGreaterThanEqualFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 16));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 18));
        String sql = "maturityDate >= ISO_DATE(2019-04-17)";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
        Assert.assertTrue(predicate.evaluate(trade3));
    }

    @Test
    public void whenDateLessThanShouldReturnDateLessThanFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 16));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 18));
        String sql = "maturityDate < ISO_DATE(2019-04-17)";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertFalse(predicate.evaluate(trade2));
        Assert.assertFalse(predicate.evaluate(trade3));
    }

    @Test
    public void whenDateLessThanEqualShouldReturnDateLessThanEqualFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 16));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 18));
        String sql = "maturityDate <= ISO_DATE(2019-04-17)";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
        Assert.assertFalse(predicate.evaluate(trade3));
    }

    @Test
    public void whenOrShouldReturnOrFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 16));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 18));
        String sql = "book = 'book_1' OR book = 'book_2'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
        Assert.assertFalse(predicate.evaluate(trade3));
    }

    @Test
    public void whenAndShouldReturnAndFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 16));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 18));
        String sql = "book = 'book_1' AND assetClass = 'fx'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertFalse(predicate.evaluate(trade2));
        Assert.assertFalse(predicate.evaluate(trade3));
    }

    @Test
    public void whenBooleanShouldEqualWithBoolean() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 16));
        TradeMock trade2 = new TradeMock(1, "internal_book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        String sql = "internalBook = true";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
    }

    @Test
    public void whenNullShouldEqualsWithNull() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(1, "book_1", "legal_2", null, "cpty_1", LocalDate.of(2019, 4, 17));
        String sql = "book = 'book_1' AND assetClass = null";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
    }

    @Test
    public void whenCheckDataWithNullAttributeShouldReturnFalse() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", null, "cpty_1", LocalDate.of(2019, 4, 17));
        String sql = "assetClass = 2019";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
    }

    @Test(expected = Exception.class)
    public void whenInvalidAttributeShouldThrowException() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", null);
        String sql = "maturityDate.year = 2019";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
    }

    @Test
    public void whenInShouldReturnInFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 17));
        String sql = "book in ('book_1', 'book_2') AND assetClass = 'fx'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
        Assert.assertFalse(predicate.evaluate(trade3));
    }

    @Test
    public void whenNotInShouldReturnNotInFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 17));
        String sql = "NOT (book in ('book_1', 'book_2')) AND assetClass = 'fx'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
        Assert.assertFalse(predicate.evaluate(trade2));
        Assert.assertTrue(predicate.evaluate(trade3));
    }

    @Test
    public void whenLikeShouldReturnLikeFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "xxxbook_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 17));
        String sql = "book like 'book%'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
        Assert.assertFalse(predicate.evaluate(trade3));
    }

    @Test
    public void whenContainsShouldReturnContainsFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        trade1.setUserRoles(Lists.newArrayList("role_1", "role_2", "role_3"));
        trade2.setUserRoles(Lists.newArrayList("role_1", "role_2"));

        BeanFilter predicate = buildPredicate("userRoles contains 'role_3'");
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertFalse(predicate.evaluate(trade2));

        predicate = buildPredicate("userRoles contains 'role_2'");
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));

        predicate = buildPredicate("userRoles contains 'role_4'");
        Assert.assertFalse(predicate.evaluate(trade1));
        Assert.assertFalse(predicate.evaluate(trade2));
    }

    @Test
    public void whenContainsOnNullObjectShouldReturnFalse() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        BeanFilter predicate = buildPredicate("userRoles contains 'role_1'");
        Assert.assertFalse(predicate.evaluate(trade1));
    }

    @Test
    public void whenContainsOnNonCollectionObjectShouldReturnFalse() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        BeanFilter predicate = buildPredicate("book contains 'book_1'");
        Assert.assertFalse(predicate.evaluate(trade1));
    }

    @Test
    public void whenAndOrShouldReturnAndOrFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 17));

        String sql = "(book = 'book_1' OR legalEntity = 'legal_2') AND assetClass = 'fx'";

        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
        Assert.assertFalse(predicate.evaluate(trade3));
    }

    @Test
    public void whenInAndOrShouldReturnInAndOrFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "book_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 17));

        String sql = "(book = 'book_1' OR legalEntity in ('legal_1', 'legal_2')) AND assetClass = 'fx'";

        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
        Assert.assertFalse(predicate.evaluate(trade3));
    }

    @Test
    public void whenLikeInAndOrShouldReturnLikeInAndOrFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        TradeMock trade2 = new TradeMock(2, "book_2", "legal_2", "fx", "cpty_2", LocalDate.of(2019, 4, 17));
        TradeMock trade3 = new TradeMock(3, "xxxbook_3", "legal_3", "fx", "cpty_3", LocalDate.of(2019, 4, 17));

        String sql = "(book like 'book_%' OR legalEntity in ('legal_1', 'legal_2')) AND assetClass = 'fx'";

        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
        Assert.assertTrue(predicate.evaluate(trade2));
        Assert.assertFalse(predicate.evaluate(trade3));
    }

    @Test
    public void whenOptionalAttributeShouldGetDataFromOptional() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.of(new TradeGenralMock("HK", 1)));
        String sql = "tradeGeneral.executionVenue = 'HK'";

        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
    }

    @Test
    public void whenCheckDataWithEmptyOptionalAttributeShouldReturnFalse() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());
        String sql = "tradeGeneral.executionVenue = 'HK'";

        BeanFilter predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
    }

    @Test
    public void whenValidationShouldInvokeFunction() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());
        String sql = "checkRegion('HK', 'Asia') and book = 'book_1'";

        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));

        sql = "checkRegion('HK', 'US') and book = 'book_1'";
        predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
    }

    @Test
    public void whenValidationWithObjectPropertyShouldInvokeFunction() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());

        String sql = "checkMaturityDate('HK', maturityDate.year) and book = 'book_1'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));

        sql = "checkMaturityDate('HK', maturityDate.month.value) and book = 'book_1'";
        predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
    }

    @Test(expected = Exception.class)
    public void whenNonExistValidationShouldReturnFalse() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());

        String sql = "checkMaturityDate_nonExist('HK', maturityDate.year) and book = 'book_1'";
        BeanFilter predicate = buildPredicate(sql);
        predicate.evaluate(trade1);
    }

    @Test
    public void whenFunctionCallWithoutParameterShouldInvokeFunction() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());

        String sql = "functionCallWithoutParameter() = 'no_parameter' and book = 'book_1'";
        BeanFilter predicate = buildPredicate(sql);
        predicate.evaluate(trade1);
        Assert.assertTrue(predicate.evaluate(trade1));
    }

    @Test
    public void whenFunctionCallWithStringParameterShouldInvokeFunction() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());

        String sql = "functionCallTest('HK', 'China') = 'Asia' and book = 'book_1'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
    }

    @Test
    public void whenFunctionCallInShouldUseInFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());

        String sql = "functionCallTest('HK', 'China') in ('Asia', 'Europe')";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertThat(predicate.get(), Matchers.instanceOf(FunctionPredicate.class));
        Assert.assertThat(((FunctionPredicate)predicate.get()).getPredicate(), Matchers.instanceOf(InPredicate.class));
        Assert.assertTrue(predicate.evaluate(trade1));
    }

    @Test
    public void whenFunctionCallWithOptionalReturnValueShouldEvaluateValueInOptional() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());

        String sql = "functionCallReturnOptional('HK') = 'HK' and book = 'book_1'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));

        sql = "functionCallReturnOptional('others') = null and book = 'book_1'";
        predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
    }

    @Test
    public void whenFunctionCallWithNumberParameterShouldInvokeFunction() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());

        String sql = "toUpperCase(book) = 'BOOK_1' and book = 'book_1' and max(1,2) = 2";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
    }

    @Test
    public void whenFunctionCallWithObjectPropertyShouldInvokeFunction() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());

        String sql = "toUpperCase(book) = 'BOOK_1' and toUpperCase('book') = 'BOOK' and book = 'book_1'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
    }

    @Test
    public void whenFunctionCallWithObjectAsParameterShouldInvokeFunction() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());

        String sql = "functionCallWithObject(it, 'test_user') = 'test_user_functionCallWithObject_TradeMock_1' and toUpperCase('book') = 'BOOK' and book = 'book_1'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
    }

    @Test
    public void whenValidationAndFunctionCallWithParameterShouldInvokeFunction() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());

        String sql = "checkRegion('HK', 'Asia') and functionCallTest('Sydney', 'Australia') = 'Australia' and book = 'book_1'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
    }

    @Test
    public void whenAttributeExistsInRuleContextShouldExecuteAttribute() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());

        String sql = "mock_attribute_a = 'a' and book = 'book_1'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));

        sql = "mock_attribute_b has 'c' and book = 'book_1'";
        predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
    }

    @Test
    public void whenAttributeInShouldUseInFilter() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());

        String sql = "mock_attribute_a in ('a', 'b', 'c')";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertThat(predicate.get(), Matchers.instanceOf(AttributeAwareBeanPredicate.class));
        Assert.assertThat(((AttributeAwareBeanPredicate)predicate.get()).getPredicate(), Matchers.instanceOf(InPredicate.class));
        Assert.assertTrue(predicate.evaluate(trade1));
    }

    @Test
    public void whenBooleanAttributeShouldEvaluateAsBoolean() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());

        String sql = "mock_boolean_attribute_a = true and book = 'book_1'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));

        sql = "mock_boolean_attribute_a = false and book = 'book_1'";
        predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
    }

    @Test
    public void whenOptionalAttributeShouldEvaluateValueInOptional() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());

        String sql = "optional_mock_attribute_c = 'opt_c' and book = 'book_1'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertTrue(predicate.evaluate(trade1));
    }

    @Test
    public void whenEmptyOptionalAttributeShouldEvaluateAsNull() throws Exception {
        TradeMock trade1 = new TradeMock(1, "book_1", "legal_1", "fx", "cpty_1", LocalDate.of(2019, 4, 17));
        trade1.setTradeGeneral(Optional.empty());

        String sql = "optional_mock_attribute_d = 'opt_c' and book = 'book_1'";
        BeanFilter predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));

        sql = "optional_mock_attribute_d = null and book = 'book_1'";
        predicate = buildPredicate(sql);
        Assert.assertFalse(predicate.evaluate(trade1));
    }

    private BeanFilter buildPredicate(String sql) {
        SqlGrammarParser parser = buildParser(sql);
        SqlVisitor<BeanFilter> visitor = new SqlVisitor<>(new BeanFilterBuilder(), ruleContext);
        BeanFilter predicate = visitor.visitRestriction(parser.restriction());
        return predicate;
    }

    private SqlGrammarParser buildParser(String sql) {
        AbstractCriteria abstractCriteria = Mockito.mock(AbstractCriteria.class);
        SqlGrammarLexer lexer = new SqlGrammarLexer(CharStreams.fromString(sql));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SqlGrammarParser parser = new SqlGrammarParser(tokens);
        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
        ParseErrorListener errorListener = new ParseErrorListener();
//        ParseErrorListener errorListener = new ParseErrorListener(abstractCriteria);
        parser.addErrorListener(errorListener);
        return parser;
    }

}
