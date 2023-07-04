package com.green.firstproject.mail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmailPostDto {
    private String[] email;
}
