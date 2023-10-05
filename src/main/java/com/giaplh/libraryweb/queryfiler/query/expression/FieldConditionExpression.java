package com.giaplh.libraryweb.queryfiler.query.expression;

import com.giaplh.libraryweb.queryfiler.query.constants.LogicalOperator;
import com.giaplh.libraryweb.queryfiler.query.constants.SQLCondition;
import javax.persistence.criteria.*;

public class FieldConditionExpression extends ConditionExpression {
    private String compareField;

    public FieldConditionExpression(
        String field,
        LogicalOperator compareOperator,
        SQLCondition sqlCondition,
        String compareField
    ) {
        super(field, compareOperator, sqlCondition);
        this.compareField = compareField;
    }

    public String getCompareField() {
        return compareField;
    }

    public void setCompareField(String compareField) {
        this.compareField = compareField;
    }

    @Override
    public Predicate toPredicate(CriteriaBuilder cb, Root<?> root) {
        switch (sqlCondition) {
            case EQUALS:
                return cb.equal(root.get(this.field), root.get(this.compareField));
            case NOT_EQUALS:
                return cb.notEqual(root.get(this.field), root.get(this.compareField));
            case LESS_THAN:
                return cb.lessThan(root.get(this.field), root.get(this.compareField));
            case LESS_THAN_OR_EQUAL:
                return cb.lessThanOrEqualTo(
                    root.get(this.field),
                    root.get(this.compareField)
                );
            case GREATER_THAN:
                return cb.greaterThan(root.get(this.field), root.get(this.compareField));
            case GREATER_THAN_OR_EQUAL:
                return cb.greaterThanOrEqualTo(
                    root.get(this.field),
                    root.get(this.compareField)
                );
            default:
                return null;
        }
    }
}
