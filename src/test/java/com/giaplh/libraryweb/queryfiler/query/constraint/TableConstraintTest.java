package com.giaplh.libraryweb.queryfiler.query.constraint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TableConstraintTest {
    private static final HashMap<String, Class<?>> exposedColumns = new HashMap<>();

    @BeforeAll
    public static void init() {
        exposedColumns.put("col1", String.class);
        exposedColumns.put("col2", Integer.class);
        exposedColumns.put("col3", Double.class);
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
}
