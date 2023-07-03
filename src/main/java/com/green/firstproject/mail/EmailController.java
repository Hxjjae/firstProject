package com.green.firstproject.mail;

import com.green.firstproject.mail.model.EmailPostDto;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send-mail")
    public ResponseEntity sendMail(@RequestBody EmailPostDto dto) {
        EmailMessage emailMessage = EmailMessage.builder()
                .to(dto.getEmail())
                .subject("스터디 플래너에서 보내드립니다.")
                .message("오늘의 공부내용을 작성해주세요.")
                .build();
        emailService.sendMail(emailMessage);
        return new ResponseEntity(HttpStatus.OK);
    }
}
