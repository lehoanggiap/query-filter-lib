package com.giaplh.libraryweb.queryfiler.query.expression;

import com.giaplh.libraryweb.queryfiler.query.constants.LogicalOperator;
import com.giaplh.libraryweb.queryfiler.query.constants.SQLCondition;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ValueConditionExpression extends ConditionExpression {
    private String value;

    public ValueConditionExpression(
        String field,
        LogicalOperator compareOperator,
        SQLCondition sqlCondition,
        String value
    ) {
        super(field, compareOperator, sqlCondition);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public Predicate toPredicate(CriteriaBuilder cb, Root<?> root) {
        switch (sqlCondition) {
            case EQUALS:
                return cb.equal(root.get(this.field), value);
            case NOT_EQUALS:
                return cb.notEqual(root.get(this.field), value);
            case LESS_THAN:
                return cb.lt(root.get(this.field), Integer.valueOf(value));
            case LESS_THAN_OR_EQUAL:
                return cb.lessThanOrEqualTo(root.get(this.field), Integer.valueOf(value));
            case GREATER_THAN:
                return cb.greaterThan(root.get(this.field), Integer.valueOf(value));
            case GREATER_THAN_OR_EQUAL:
                return cb.greaterThanOrEqualTo(
                    root.get(this.field),
                    Integer.valueOf(value)
                );
            default:
                return null;
        }
    }
}
