package com.green.firstproject.mail;

import com.green.firstproject.mail.model.EmailPostDto;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;
    private final EmailMessage emailMessage;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailMessage message) {


        emailService.sendail(message.getTo()
                , message.getSubject()
                , message.getMessage());

        return "이메일 전송 완료";
    }


    @PostMapping("/send-mail")
    public ResponseEntity sendMail(@RequestBody EmailPostDto dto) {
        EmailMessage emailMessage = EmailMessage.builder()
                .to(dto.getEmail())
                .subject("스터디 플래너에서 보내드립니다.")
                .message("오늘의 공부내용을 작성해주세요.")
                .build();
        emailService.sendEmail(emailMessage);
        return new ResponseEntity(HttpStatus.OK);
    }
}
