package com.giaplh.libraryweb.queryfiler.query.data.request;

import com.giaplh.libraryweb.queryfiler.query.data.validation.TableConstraint;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BasicSQLQueryInfo extends QueryInfo{

    /**
     * To make a dynamic class, create a Child class like SQLQueryInfo With Aggregate, or With Join Table
     */
    public BasicSQLQueryInfo(List<String> fields, TableConstraint tableConstraint) {
        super(fields, tableConstraint);
    }
    public void validate(){
       tableConstraint.validateFields(fields);
    }
}
