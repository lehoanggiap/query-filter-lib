package com.giaplh.libraryweb.queryfiler.query.statement.sql;

import com.giaplh.libraryweb.queryfiler.query.command.sql.SelectCommand;
import com.giaplh.libraryweb.queryfiler.query.constraint.TableConstraint;
import com.giaplh.libraryweb.queryfiler.query.expression.ConditionExpression;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SelectStatement<E> extends SQLStatement<CriteriaQuery<E>, SelectCommand> {
    private Class<E> rootClass;

    public SelectStatement(
        TableConstraint tableConstraint,
        EntityManager em,
        Class<E> rootClass
    ) {
        super(tableConstraint, em);
        this.rootClass = rootClass;
    }

    @Override
    public CriteriaQuery<E> buildCriteria() {
        if (baseCommand == null) {
            throw new IllegalArgumentException(
                "Can not build statement since base command is null"
            );
        }
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(rootClass);
        Root<E> root = cq.from(rootClass);

        // Build criteria select with selected fields
        // TODO: handle case having non selected fields
        cq.multiselect(
            baseCommand
                .getSelectFields()
                .stream()
                .map(root::get)
                .collect(Collectors.toList())
        );

        // if there isn't any conditions -> simply return query
        if (whereCommand == null) {
            return cq;
        }

        Predicate combinePredicate = null;

        tableConstraint.validateFieldConditions(
            whereCommand.getFieldConditionExpressions()
        );
        tableConstraint.validateValueConditions(
            whereCommand.getValueConditionExpressions()
        );

        for (ConditionExpression conditionExpression : whereCommand.getConditionExpressions()) {
            if (combinePredicate == null) {
                combinePredicate = conditionExpression.toPredicate(cb, root);
                continue;
            }
            combinePredicate = conditionExpression.composite(cb, root, combinePredicate);
        }

        return cq;
    }
}
