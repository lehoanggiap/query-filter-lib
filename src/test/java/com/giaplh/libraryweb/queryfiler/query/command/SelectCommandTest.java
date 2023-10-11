package com.giaplh.libraryweb.queryfiler.query.command;

import com.giaplh.libraryweb.queryfiler.query.command.model.SelectModel;
import com.giaplh.libraryweb.queryfiler.query.command.sql.SelectCommand;
import com.giaplh.libraryweb.queryfiler.query.statement.sql.SelectStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SelectCommandTest {
    private List<String> selectFields = Arrays.asList("col1", "col2");

    @Mock
    private SelectStatement<SelectModel> selectStatement;

    @InjectMocks
    private SelectCommand selectCommand;

    @Test
    public void giveSelectFieldsNull_WhenSetSelectFields_ThenCommandFieldsNotAddSelectFields() {
        int size = selectCommand.getCommandFields().size();
        selectCommand.setSelectFields(null);
        Assertions.assertEquals(selectCommand.getCommandFields().size(), size);
    }

    @Test
    public void giveSelectFieldsEmpty_WhenSetSelectFields_ThenCommandFieldsNotAddSelectFields() {
        int size = selectCommand.getCommandFields().size();
        selectCommand.setSelectFields(Collections.emptyList());
        Assertions.assertEquals(selectCommand.getCommandFields().size(), size);
    }

    @Test
    public void giveSelectFieldsValid_WhenSetSelectFields_ThenCommandFieldsContainSelectFields() {
        selectCommand.setSelectFields(selectFields);
        Assertions.assertTrue(selectCommand.getCommandFields().containsAll(selectFields));
    }

    @Test
    public void givenSelectStatementNotNull_WhenBuildSelectStatement_thenSetBaseCommandSuccess() {
        Mockito
            .doNothing()
            .when(selectStatement)
            .setBaseCommand(Mockito.any(SelectCommand.class));
        this.selectCommand.buildStatement();
        Mockito
            .verify(selectStatement, Mockito.times(1))
            .setBaseCommand(this.selectCommand);
    }
}
