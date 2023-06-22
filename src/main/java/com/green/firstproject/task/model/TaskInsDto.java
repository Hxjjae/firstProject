package com.green.firstproject.task.model;

import lombok.Data;

@Data
public class TaskInsDto {
    private String title;
    private String description;
    private int taskPoint;
    private String time;
}
