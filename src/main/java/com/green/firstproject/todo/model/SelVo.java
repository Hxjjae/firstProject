package com.green.firstproject.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SelVo {
    private long itodo;
    private String title;
    private String ctnt;
    private String creaetd_at;
    private String updated_at;
    private int del_yn;
    private long isticker;
    private long icategory;
    private long iuser;
}
