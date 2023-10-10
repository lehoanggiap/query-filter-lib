package com.giaplh.libraryweb.queryfiler.query.constraint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.giaplh.libraryweb.queryfiler.query.exception.BadRequestException;
import com.giaplh.libraryweb.queryfiler.query.expression.FieldConditionExpression;
import com.giaplh.libraryweb.queryfiler.query.expression.ValueConditionExpression;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TableConstraint {
    //TODO: validate conditon of two fields that has different type
    //GiapLH suggested solution: past the type to the exposed columns

    protected final Map<String, Class<?>> exposedColumns;

    public boolean validateFields(List<String> fields) {
        return fields.stream().noneMatch(field -> exposedColumns.get(field) == null);
    }

    public TableConstraint(Map<String, Class<?>> exposedColumns) {
        if (exposedColumns == null) {
            throw new IllegalArgumentException("Exposed columns must not be null");
        }
        this.exposedColumns = exposedColumns;
    }

    public void validateFieldConditions(
        List<FieldConditionExpression> fieldConditionExpressions
    ) {
        String field;
        String compareField;
        for (FieldConditionExpression fieldConditionExpression : fieldConditionExpressions) {
            field = fieldConditionExpression.getField();
            compareField = fieldConditionExpression.getCompareField();
            Class<?> fieldType = exposedColumns.get(field);
            Class<?> compareFieldType = exposedColumns.get(compareField);
            if (!compareFieldType.isAssignableFrom(fieldType)) {
                log.error(
                    "{} can not be compared with {} because they have different type",
                    field,
                    compareField
                );
                throw new BadRequestException("Invalid compare field of field " + field);
            }
        }
    }

    public void validateValueConditions(
        List<ValueConditionExpression> valueConditionExpressions
    ) {
        String field;
        String value;
        ObjectMapper objectMapper = new ObjectMapper();
        for (ValueConditionExpression valueConditionExpression : valueConditionExpressions) {
            field = valueConditionExpression.getField();
            value = valueConditionExpression.getValue();
            Class<?> fieldType = exposedColumns.get(field);
            try {
                objectMapper.readValue(value, fieldType);
            } catch (JsonProcessingException e) {
                log.error("Exception when convert value {} of field: {}", value, field);
                throw new BadRequestException("Invalid compare value of field " + field);
            }
        }
    }
}
