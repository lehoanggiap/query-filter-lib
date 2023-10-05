package com.giaplh.libraryweb.queryfiler.query.command.sql;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.giaplh.libraryweb.queryfiler.query.command.DBCommand;
import com.giaplh.libraryweb.queryfiler.query.statement.sql.SQLStatement;
import java.util.ArrayList;
import java.util.List;

public abstract class SQLCommand implements DBCommand {
    @JsonIgnore
    protected List<String> commandFields = new ArrayList<>();

    public abstract SQLStatement buildStatement();

    public List<String> getCommandFields() {
        return commandFields;
    }
}
