package com.green.firstproject.memo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemoAllListVo {
    private int imemo;
    private int iuser;
    private String title;
    private String ctnt;
    private String createdAt;
    private String updatedAt;
}
