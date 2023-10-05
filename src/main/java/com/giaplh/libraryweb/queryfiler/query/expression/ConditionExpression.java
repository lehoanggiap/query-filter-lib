package com.giaplh.libraryweb.queryfiler.query.expression;

import com.giaplh.libraryweb.queryfiler.query.constants.LogicalOperator;
import com.giaplh.libraryweb.queryfiler.query.constants.SQLCondition;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class ConditionExpression implements CommandExpression {
    protected String field;

    protected LogicalOperator compareOperator;

    protected SQLCondition sqlCondition;

    protected ConditionExpression(
        String field,
        LogicalOperator compareOperator,
        SQLCondition sqlCondition
    ) {
        this.field = field;
        this.compareOperator = compareOperator;
        this.sqlCondition = sqlCondition;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public LogicalOperator getCompareOperator() {
        return compareOperator;
    }

    public void setCompareOperator(LogicalOperator compareOperator) {
        this.compareOperator = compareOperator;
    }

    public SQLCondition getSqlCondition() {
        return sqlCondition;
    }

    public void setSqlCondition(SQLCondition sqlCondition) {
        this.sqlCondition = sqlCondition;
    }

    public abstract Predicate toPredicate(CriteriaBuilder cb, Root<?> root);

    public Predicate composite(CriteriaBuilder cb, Root<?> root, Predicate predicate) {
        Predicate conditionPredicate = this.toPredicate(cb, root);
        switch (compareOperator) {
            case OR:
                return cb.or(predicate, conditionPredicate);
            case AND:
                return cb.and(predicate, conditionPredicate);
        }
        return null;
    }
}
