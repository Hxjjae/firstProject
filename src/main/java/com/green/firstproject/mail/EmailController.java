package com.green.firstproject.mail;

import com.green.firstproject.mail.model.EmailPostDto;
import com.green.firstproject.mail.model.EmailResponseDto;
import com.green.firstproject.user.UserService;
import com.green.firstproject.user.model.UserEntity;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;
    private final UserService userService;

    @PostMapping("/send-mail")
    public ResponseEntity<EmailResponseDto> sendMail(@RequestBody EmailPostDto dto) {
        List<String> emailList = getEmailListFromIuser(dto.getIuser(), userService);
        emailService.setEmailList(emailList);
        return ResponseEntity.ok(new EmailResponseDto("SUCCESS"));
    }

    private List<String> getEmailListFromIuser(List<Integer> iuserList, UserService userService) {
        List<String> emailList = new ArrayList<>();
        for (Integer iuser : iuserList) {
            UserEntity user = userService.getUserByIuser(iuser);
            if (user != null) {
                emailList.add(user.getEmail());
            }
        }
        return emailList;
    }
}
