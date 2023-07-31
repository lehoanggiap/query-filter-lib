package com.giaplh.libraryweb.queryfiler.query.data.request;

import com.giaplh.libraryweb.queryfiler.query.data.select.AggregateSelectInfo;
import com.giaplh.libraryweb.queryfiler.query.data.select.SelectInfo;
import com.giaplh.libraryweb.queryfiler.query.data.validation.TableConstraint;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class AggregateSQLQueryInfo extends BasicSQLQueryInfo{
    private List<AggregateSelectInfo> aggregateSelectInfoList;

    public AggregateSQLQueryInfo(List<String> fields, TableConstraint tableConstraint) {
        super(fields, tableConstraint);
        extractFieldsFromAggregateInfo();
    }

    /**
     * After having a list of select fields. <br>
     * If there is any aggregate field, call this function. <br>
     * For validation of SQL Statement
     */
    private void extractFieldsFromAggregateInfo(){
        if(CollectionUtils.isEmpty(aggregateSelectInfoList)){
            return;
        }
        if(CollectionUtils.isEmpty(this.getFields())){
            return;
        }

        List<String> fields = aggregateSelectInfoList
                .stream()
                .map(SelectInfo::getFieldName)
                .collect(Collectors.toList());
        fields.addAll(this.getFields());
        this.setFields(fields);
    }
}
