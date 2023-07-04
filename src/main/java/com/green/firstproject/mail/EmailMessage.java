package com.green.firstproject.mail;

import com.green.firstproject.mail.model.EmailPostDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailMessage {
    private String to;
    private String subject;
    private String message;
}
