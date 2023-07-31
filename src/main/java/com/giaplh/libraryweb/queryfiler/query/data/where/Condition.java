package com.giaplh.libraryweb.queryfiler.query.data.where;

import com.giaplh.libraryweb.queryfiler.query.constants.LogicalOperator;
import com.giaplh.libraryweb.queryfiler.query.constants.SQLCondition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Condition {
    private String field;
    private SQLCondition condition;
    private LogicalOperator logicalOperator;
}
