package com.everest.rule.domain;

import com.everest.rule.RuleContext;
import com.everest.rule.SqlUtils;
import com.everest.rule.parser.BeanFilter;
import com.everest.rule.parser.BeanFilterBuilder;
import com.everest.rule.parser.column.ObjectWrapperColumnNameConvertor;
import com.everest.rule.parser.sql.SqlVisitor;
import com.everest.rule.sql.expr.parser.generated.SqlGrammarParser;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public abstract class AbstractCriteria<T> implements Criteria<T> {

    private final Long id;
    private final Long sequence;
    private boolean active;
    private final String condition;
    private final String description;
    private BeanFilter predicate;

    protected AbstractCriteria(Long id, Long sequence, boolean active, String condition, String description) {
        this.id = id;
        this.sequence = sequence;
        this.active = active;
        this.condition = condition;
        this.description = description;
    }

    public void init(RuleContext ruleContext) throws ParseCancellationException {
        SqlGrammarParser parser = SqlUtils.buildParser(this.condition, this);
        SqlVisitor<BeanFilter> visitor = new SqlVisitor<>(BeanFilterBuilder.newInstance(), new ObjectWrapperColumnNameConvertor(), ruleContext);
        this.predicate = visitor.visitRestriction(parser.restriction());
    }

    public Long getId() {
        return id;
    }

    public Long getSequence() {
        return sequence;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCondition() {
        return condition;
    }

    public String getDescription() {
        return description;
    }

    public BeanFilter getPredicate() {
        return predicate;
    }

    @Override
    public String toString() {
        return "AbstractCriteria{" +
                "id=" + id +
                ", sequence=" + sequence +
                ", active=" + active +
                ", condition='" + condition + '\'' +
                ", description='" + description + '\'' +
                ", predicate=" + predicate +
                '}';
    }
}
