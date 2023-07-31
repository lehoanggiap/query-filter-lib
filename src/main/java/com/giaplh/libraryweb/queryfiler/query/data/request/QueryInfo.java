package com.giaplh.libraryweb.queryfiler.query.data.request;

import com.giaplh.libraryweb.queryfiler.query.data.validation.TableConstraint;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class QueryInfo {

    public QueryInfo(List<String> fields, TableConstraint tableConstraint){
        this.setFields(fields);
    }

    protected List<String> fields;

    protected TableConstraint tableConstraint;
}

