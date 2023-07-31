package com.giaplh.libraryweb.queryfiler.server.dto;

import com.giaplh.libraryweb.queryfiler.query.data.request.BasicSQLQueryInfo;
import com.giaplh.libraryweb.queryfiler.server.constraint.StudentTableConstraint;

import java.util.Arrays;
import java.util.List;

public class StudentDTO extends BasicSQLQueryInfo {

    private final static StudentTableConstraint studentTableConstraint = new StudentTableConstraint(
            "student",
            Arrays.asList("name")
    );

    public StudentDTO(List<String> fields) {
        super(fields, studentTableConstraint);
        validate();
    }

}
