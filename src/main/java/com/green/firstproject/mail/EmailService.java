package com.green.firstproject.mail;

import com.green.firstproject.mail.model.EmailPostDto;
import com.green.firstproject.user.UserService;
import com.green.firstproject.user.model.UserEntity;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private List<String> emailList;

    @Scheduled(cron = "0 43 14 * * 1-5")
    public void sendMail() {
        for (String email : emailList) {
            EmailMessage emailMessage = EmailMessage.builder()
                    .to(email)
                    .subject("스터디 확인다.")
                    .message("오늘의 수수수수요.")
                    .build();
            sendEmail(emailMessage);
        }
    }

    public void sendEmail(EmailMessage emailMessage) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            mimeMessageHelper.setTo(emailMessage.getTo());
            mimeMessageHelper.setSubject(emailMessage.getSubject());
            mimeMessageHelper.setText(emailMessage.getMessage(), false);
            javaMailSender.send(mimeMessage);
            log.info("Email sent successfully!");
        } catch (MessagingException e) {
            log.error("Failed to send email", e);
            throw new RuntimeException(e);
        }


}
}
