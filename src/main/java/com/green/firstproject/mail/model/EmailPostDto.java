package com.green.firstproject.mail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class EmailPostDto {
    private List<Integer> iuser;
}
