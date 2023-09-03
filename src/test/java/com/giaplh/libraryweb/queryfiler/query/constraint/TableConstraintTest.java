package com.giaplh.libraryweb.queryfiler.query.constraint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TableConstraintTest {

    private static final HashSet<String> exposedColumns = new HashSet<>();


    @BeforeAll
    public static void init() {
        exposedColumns.add("col1");
        exposedColumns.add("col2");
        exposedColumns.add("col3");
    }

    @Test
    public void givenNull_whenInitTableConstraint_ThenThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TableConstraint tableConstraint = new TableConstraint(null);
        });
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
