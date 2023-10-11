package com.giaplh.libraryweb.queryfiler.query.command;

import com.giaplh.libraryweb.queryfiler.query.statement.DBStatement;
import java.util.List;

public interface DBCommand {
    List<String> extractColumns();

    DBStatement buildStatement();
}
