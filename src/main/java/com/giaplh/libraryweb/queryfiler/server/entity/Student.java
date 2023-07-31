package com.giaplh.libraryweb.queryfiler.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {

    @Id
    private Long id;

    private String name;

    private byte age;

}
