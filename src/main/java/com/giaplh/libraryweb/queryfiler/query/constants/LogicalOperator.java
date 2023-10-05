package com.giaplh.libraryweb.queryfiler.query.constants;

public enum LogicalOperator {
    AND("AND"),
    OR("OR");

    private final String name;

    private LogicalOperator(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
