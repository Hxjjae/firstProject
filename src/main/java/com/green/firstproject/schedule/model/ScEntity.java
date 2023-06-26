package com.green.firstproject.schedule.model;

import lombok.Data;

@Data
public class ScEntity {
    private int ischedule;
    private String title;
    private String date;
    private String time;
    private String description;
    private int finishYn;
    private int delYn;
}
