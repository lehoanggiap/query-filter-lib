package com.giaplh.libraryweb.queryfiler.query.statement.impl;

import com.giaplh.libraryweb.queryfiler.query.data.request.BasicSQLQueryInfo;
import com.giaplh.libraryweb.queryfiler.query.statement.AbstractStatement;

import java.util.List;

public class SQLStatement extends AbstractStatement {
    public SQLStatement(BasicSQLQueryInfo queryInfo) {
        super(queryInfo);
    }



    /**
     * Validate the selecti info from the SQLQueryInfo <br><br>
     *
     * <b><u>Validation: </u></b> <br>
     * - Don't need to check null or empty of the fields and exposedColumns
     * - These lists was already been validated when initializing
     */
    @Override
    public boolean validate() {
        List<String> fields = queryInfo.getFields();

        //don't know the valid name of each table
        //must let each Table decide its name





        return true;
    }
}
