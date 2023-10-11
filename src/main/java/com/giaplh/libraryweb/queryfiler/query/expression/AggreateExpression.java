package com.giaplh.libraryweb.queryfiler.query.expression;

import com.giaplh.libraryweb.queryfiler.query.constants.AggreateSQLFunction;
import org.springframework.context.annotation.Description;

@Description("Not ready to use")
public class AggreateExpression implements CommandExpression {
    private String field;

    private AggreateSQLFunction aggreateSQLFunction;

    public AggreateExpression(String field, AggreateSQLFunction aggreateSQLFunction) {
        this.field = field;
        this.aggreateSQLFunction = aggreateSQLFunction;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public AggreateSQLFunction getAggreateSQLFunction() {
        return aggreateSQLFunction;
    }

    public void setAggreateSQLFunction(AggreateSQLFunction aggreateSQLFunction) {
        this.aggreateSQLFunction = aggreateSQLFunction;
    }
}
