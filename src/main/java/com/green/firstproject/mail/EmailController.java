package com.green.firstproject.mail;

import com.green.firstproject.mail.model.EmailPostDto;
import com.green.firstproject.mail.model.EmailResponseDto;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send-mail")
    public ResponseEntity<EmailResponseDto> sendMail() {
        return ResponseEntity.ok(new EmailResponseDto("SUCCESS"));
    }
}
