package com.green.firstproject.timer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class TimerVo {
    private int itimer;
    private String studyLine;
    private String deadLine;
    private int iuser;
    private int level;
}
