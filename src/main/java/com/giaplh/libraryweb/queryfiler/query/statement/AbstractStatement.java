package com.giaplh.libraryweb.queryfiler.query.statement;

import com.giaplh.libraryweb.queryfiler.query.data.request.QueryInfo;

import java.util.List;

public abstract class AbstractStatement implements Statement{

    protected QueryInfo queryInfo;
    public AbstractStatement(QueryInfo queryInfo){
        if(queryInfo == null){
            throw new IllegalArgumentException("QueryInfo must not be null");
        }
        this.queryInfo = queryInfo;
    }

    protected List<String> extractedFields(){
        return null;
    }
}
