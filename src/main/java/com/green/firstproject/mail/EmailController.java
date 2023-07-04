package com.green.firstproject.mail;

import com.green.firstproject.mail.model.EmailListDto;
import com.green.firstproject.mail.model.EmailPostDto;
import com.green.firstproject.mail.model.EmailResponseDto;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService service;

    @GetMapping("/send-mail")
    public ResponseEntity<EmailResponseDto> sendMail(@RequestParam(value = "email") List<String> emailList) {
        EmailListDto dto = new EmailListDto();
        dto.setEmail(emailList);
        service.sendMail();
        return ResponseEntity.ok(new EmailResponseDto("SUCCESS"));
    }
}
