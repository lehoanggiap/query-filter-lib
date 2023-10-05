package com.giaplh.libraryweb.queryfiler.query.command.sql;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.giaplh.libraryweb.queryfiler.query.expression.ConditionExpression;
import com.giaplh.libraryweb.queryfiler.query.expression.FieldConditionExpression;
import com.giaplh.libraryweb.queryfiler.query.expression.ValueConditionExpression;
import com.giaplh.libraryweb.queryfiler.query.statement.sql.SQLStatement;
import com.giaplh.libraryweb.queryfiler.query.util.CollectionUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WhereCommand extends CommandDecorator {
    @JsonIgnore
    private BaseCommand baseCommand;

    private List<ValueConditionExpression> valueConditionExpressions;

    private List<FieldConditionExpression> fieldConditionExpressions;

    @JsonIgnore
    private List<ConditionExpression> conditionExpressions = new ArrayList<>();

    public WhereCommand(BaseCommand baseCommand) {
        if (baseCommand == null) {
            throw new IllegalArgumentException("Base command can not be null");
        }
        this.baseCommand = baseCommand;
    }

    @Override
    public List<String> extractColumns() {
        return Collections.emptyList();
    }

    @Override
    public SQLStatement buildStatement() {
        SQLStatement statement = this.baseCommand.buildStatement();
        statement.setWhereCommand(this);
        return statement;
    }

    public List<ValueConditionExpression> getValueConditionExpressions() {
        return valueConditionExpressions;
    }

    public void setValueConditionExpressions(
        List<ValueConditionExpression> valueConditionExpressions
    ) {
        this.valueConditionExpressions = valueConditionExpressions;
        CollectionUtil.addChildList(conditionExpressions, valueConditionExpressions);
    }

    public List<FieldConditionExpression> getFieldConditionExpressions() {
        return fieldConditionExpressions;
    }

    public void setFieldConditionExpressions(
        List<FieldConditionExpression> fieldConditionExpressions
    ) {
        this.fieldConditionExpressions = fieldConditionExpressions;
        CollectionUtil.addChildList(conditionExpressions, valueConditionExpressions);
    }

    public List<ConditionExpression> getConditionExpressions() {
        return conditionExpressions;
    }

    public void setConditionExpressions(List<ConditionExpression> conditionExpressions) {
        this.conditionExpressions = conditionExpressions;
    }
}
