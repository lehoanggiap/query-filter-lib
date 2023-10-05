package com.giaplh.libraryweb.queryfiler.query.command.sql;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.giaplh.libraryweb.queryfiler.query.expression.AggreateExpression;
import com.giaplh.libraryweb.queryfiler.query.statement.sql.SelectStatement;

import java.util.Collections;
import java.util.List;

public class SelectCommand extends BaseCommand {
    @JsonIgnore
    private SelectStatement selectStatement;

    private List<String> selectFields;

    private List<AggreateExpression> aggreateExpressions;

    public SelectCommand(SelectStatement selectStatement) {
        this.selectStatement = selectStatement;
    }

    @Override
    public List<String> extractColumns() {
        return Collections.emptyList();
    }

    @Override
    public SelectStatement buildStatement() {
        selectStatement.setBaseCommand(this);
        return selectStatement;
    }

    public List<String> getSelectFields() {
        return selectFields;
    }

    public void setSelectFields(List<String> selectFields) {
        if (selectFields == null || selectFields.isEmpty()) {
            return;
        }
        this.commandFields.addAll(selectFields);
        this.selectFields = selectFields;
    }

    public List<AggreateExpression> getAggreateExpressions() {
        return aggreateExpressions;
    }

    public void setAggreateExpressions(List<AggreateExpression> aggreateExpressions) {
        if (aggreateExpressions == null || aggreateExpressions.isEmpty()) {
            return;
        }
        this.aggreateExpressions = aggreateExpressions;
        // Get the fields for validation
        aggreateExpressions.forEach(
            aggreateExpression -> {
                String aggreateField = aggreateExpression.getField();
                if (aggreateField == null || aggreateField.trim().isEmpty()) {
                    return;
                }
                this.commandFields.add(aggreateExpression.getField());
            }
        );
    }
}
