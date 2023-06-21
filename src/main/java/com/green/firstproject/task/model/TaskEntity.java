package com.green.firstproject.task.model;

import lombok.Data;

@Data
public class TaskEntity {
    private Long itask;
    private String title;
    private String description;
    private String time;
    private int taskPoint;
}
