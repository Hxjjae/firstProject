package com.green.firstproject.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAllListVo {
    private int iuser;
    private String name;
    private String mainPic;
    private String objective;
    private String email;
}
