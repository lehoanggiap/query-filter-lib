package com.giaplh.libraryweb.queryfiler.query.data.validation;

import com.giaplh.libraryweb.queryfiler.query.exception.BadRequestException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Getter
@Setter
public abstract class TableConstraint {

    private String tableName;

    /*
     * The columns can be queried from the database
     * Default: empty
     */
    private List<String> exposedColumns;

    public TableConstraint(String tableName, List<String> exposedColumns){
        if(CollectionUtils.isEmpty(exposedColumns)){
            throw new IllegalArgumentException("At least one column must be exposed");
        }
        this.tableName = tableName;
        this.exposedColumns = exposedColumns;
    }

    public void validateFields(List<String> fields){
        fields.stream().forEach(field -> {
            if(!exposedColumns.contains(field)){
                String errMsg = String.format(
                        "Field %s is not valid column in table %s",
                        field,
                        this.tableName
                );
                throw new IllegalArgumentException(errMsg);
            }
        });
    }

    public void validateTableName(String tableName){
        if(!this.tableName.equalsIgnoreCase(tableName)){
            throw new BadRequestException(String.format("%s is not existed", tableName));
        }
    }

}
