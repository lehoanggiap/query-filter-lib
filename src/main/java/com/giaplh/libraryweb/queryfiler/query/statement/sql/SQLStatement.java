package com.giaplh.libraryweb.queryfiler.query.statement.sql;

import com.giaplh.libraryweb.queryfiler.query.command.sql.BaseCommand;
import com.giaplh.libraryweb.queryfiler.query.command.sql.WhereCommand;
import com.giaplh.libraryweb.queryfiler.query.constraint.TableConstraint;
import com.giaplh.libraryweb.queryfiler.query.statement.DBStatement;
import java.util.List;
import javax.persistence.EntityManager;

public abstract class SQLStatement<C, BC extends BaseCommand> implements DBStatement<C> {
    protected BC baseCommand;

    protected WhereCommand whereCommand;

    protected TableConstraint tableConstraint;

    protected EntityManager em;

    protected SQLStatement(TableConstraint tableConstraint, EntityManager em) {
        this.tableConstraint = tableConstraint;
    }

    public void setBaseCommand(BC baseCommand) {
        this.baseCommand = baseCommand;
        validate(baseCommand.getCommandFields());
    }

    public void setWhereCommand(WhereCommand whereCommand) {
        this.whereCommand = whereCommand;
        validate(whereCommand.getCommandFields());
    }

    @Override
    public boolean validate(List<String> fields) {
        return tableConstraint.validateFields(fields);
    }
}
