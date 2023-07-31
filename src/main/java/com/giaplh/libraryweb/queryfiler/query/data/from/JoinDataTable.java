package com.giaplh.libraryweb.queryfiler.query.data.from;

public class JoinDataTable extends DataTable{

    private JoinDataTable otherJoinDataTable;

    public JoinDataTable(String name, JoinDataTable otherJoinDataTable){
        super(name);
        this.otherJoinDataTable = otherJoinDataTable;
    }
    private String joinOnField;
}
