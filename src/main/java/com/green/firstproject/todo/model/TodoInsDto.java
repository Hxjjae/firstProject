package com.green.firstproject.todo.model;

import lombok.Data;

@Data
public class TodoInsDto {
    private String ctnt;
    private String title;
    private long isticker;
    private long icategory;
    private long iuser;
}
