package com.giaplh.libraryweb.queryfiler.server.constraint;

import com.giaplh.libraryweb.queryfiler.query.data.validation.TableConstraint;

import java.util.List;

public class StudentTableConstraint extends TableConstraint {
    public StudentTableConstraint(String tableName, List<String> exposedColumns) {
        super(tableName, exposedColumns);
    }
}
