package com.giaplh.libraryweb.queryfiler.query.constraint;

import com.giaplh.libraryweb.queryfiler.query.constants.SQLCondition;
import com.giaplh.libraryweb.queryfiler.query.exception.BadRequestException;
import com.giaplh.libraryweb.queryfiler.query.expression.FieldConditionExpression;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TableConstraintTest {
    private static final HashMap<String, Class<?>> exposedColumns = new HashMap<>();

    private static final List<FieldConditionExpression> fieldConditionExpressions = new ArrayList<>();

    private static final List<FieldConditionExpression> validFieldConditionExpressions = new ArrayList<>();

    @BeforeAll
    public static void init() {
        exposedColumns.put("col1", String.class);
        exposedColumns.put("col2", Integer.class);
        exposedColumns.put("col3", Double.class);
        exposedColumns.put("col4", String.class);

        FieldConditionExpression fieldConditionExpression = new FieldConditionExpression();
        fieldConditionExpression.setField("col1");
        fieldConditionExpression.setCompareField("col2");
        fieldConditionExpression.setSqlCondition(SQLCondition.EQUALS);
        fieldConditionExpressions.add(fieldConditionExpression);

        FieldConditionExpression validFieldConditionExpression = new FieldConditionExpression();
        validFieldConditionExpression.setField("col1");
        validFieldConditionExpression.setCompareField("col4");
        validFieldConditionExpressions.add(validFieldConditionExpression);
    }

    @Test
    public void givenNull_whenInitTableConstraint_ThenThrowException() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                TableConstraint tableConstraint = new TableConstraint(null);
            }
        );
    }

    @Test
    public void givenValidFields_whenValidate_thenReturnTrue() {
        List<String> validFields = new ArrayList<>();
        validFields.add("col1");
        validFields.add("col2");

        TableConstraint tableConstraint = new TableConstraint(exposedColumns);
        Assertions.assertTrue(tableConstraint.validateFields(validFields));
    }

    @Test
    public void givenInvalidFields_whenValidate_thenReturnFalse() {
        List<String> validFields = new ArrayList<>();
        validFields.add("col5");
        validFields.add("col2");

        TableConstraint tableConstraint = new TableConstraint(exposedColumns);
        Assertions.assertFalse(tableConstraint.validateFields(validFields));
    }

    @Test
    public void givenValidFieldsConditions_whenValidate_thenThrowException() {
        TableConstraint tableConstraint = new TableConstraint(exposedColumns);
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
                tableConstraint.validateFieldConditions(fieldConditionExpressions);
            }
        );
    }

    @Test
    public void givenValidFieldsConditions_whenValidate_thenNotThrowException() {
        TableConstraint tableConstraint = new TableConstraint(exposedColumns);
        Assertions.assertDoesNotThrow(
            () -> {
                tableConstraint.validateFieldConditions(validFieldConditionExpressions);
            }
        );
    }
}
