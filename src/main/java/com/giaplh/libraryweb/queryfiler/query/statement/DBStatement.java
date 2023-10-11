package com.giaplh.libraryweb.queryfiler.query.statement;

import java.util.List;

public interface DBStatement<C> {
    boolean validate(List<String> fields);

    C buildCriteria();
}
