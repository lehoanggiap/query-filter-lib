package com.giaplh.libraryweb.queryfiler.query.constraint;

import java.util.HashSet;
import java.util.List;

public class TableConstraint {

    //TODO: validate conditon of two fields that has different type
    //GiapLH suggested solution: past the type to the exposed columns

    protected final HashSet<String> exposedColumns;

    public boolean validateFields(List<String> fields) {
        return exposedColumns.containsAll(fields);
    }

    public TableConstraint(HashSet<String> exposedColumns) {
        if (exposedColumns == null) {
            throw new IllegalArgumentException("Exposed columns must not be null");
        }
        this.exposedColumns = exposedColumns;
    }
}
