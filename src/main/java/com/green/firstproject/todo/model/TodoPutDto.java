package com.green.firstproject.todo.model;

import lombok.Data;

@Data
public class TodoPutDto {
    private long itodo;
    private String title;
    private String ctnt;
    private long icategory;
}
