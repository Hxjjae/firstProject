package com.green.firstproject.memo.model;

import lombok.Data;

@Data
public class MemoEntity {
    private int imemo;
    private int iuser;
    private String title;
    private String ctnt;
    private String createdAt;
    private String updatedAt;
}
