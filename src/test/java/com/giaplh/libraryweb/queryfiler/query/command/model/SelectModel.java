package com.giaplh.libraryweb.queryfiler.query.command.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class SelectModel {
    private String firstCol;

    private String secondCol;
}
