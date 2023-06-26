package com.green.firstproject.todo.model;

import lombok.Data;

@Data
public class TodoEntity {
    private long itodo;
    private String title;
    private String ctnt;
    private String creaetd_at;
    private String updated_at;
    private int del_yn;
    private long isticker;
    private long icategory;
}
