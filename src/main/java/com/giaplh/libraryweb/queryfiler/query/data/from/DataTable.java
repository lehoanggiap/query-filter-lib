package com.giaplh.libraryweb.queryfiler.query.data.from;

import lombok.Getter;
import lombok.Setter;

// TODO: Write docs to mention that they need to pass in the TableConstraint
@Getter
@Setter
public abstract class DataTable {
    protected String name;
    public DataTable(String name){
        this.name = name;
    }
}
