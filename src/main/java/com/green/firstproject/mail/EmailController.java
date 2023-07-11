package com.green.firstproject.mail;

import com.green.firstproject.mail.model.EmailListDto;
import com.green.firstproject.mail.model.EmailPostDto;
import com.green.firstproject.mail.model.EmailResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "메일전송")
public class EmailController {

    private final EmailService service;

    @GetMapping("/send-mail")
    @Operation(summary = "메일전송 ( 자동전송 되므로 접근 X ) " +
                          "매주 월-금 11시 19시 전송")
    public ResponseEntity<EmailResponseDto> sendMail(@RequestParam(value = "email") List<String> emailList) {
        EmailListDto dto = new EmailListDto();
        dto.setEmail(emailList);
        service.sendMail();
        return ResponseEntity.ok(new EmailResponseDto("SUCCESS"));
    }
}
