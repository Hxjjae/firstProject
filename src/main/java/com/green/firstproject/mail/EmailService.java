package com.green.firstproject.mail;

import com.green.firstproject.mail.model.EmailListDto;
import com.green.firstproject.mail.model.EmailPostDto;
import com.green.firstproject.user.UserMapper;
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
    private final UserMapper mapper;

    @Scheduled(cron = "0 0 11,19 * * 1-5")
    public void sendMail() {
        List<String> emailList = mapper.selEmail();
            for (String email : emailList) {
                EmailMessage emailMessage = EmailMessage.builder()
                        .to(email)
                        .subject("스터디 플래너입니다.")
                        .message("아직 작성된 플랜이 없으시군요 " +
                                "오늘의 스터디플랜을 작성해보는건 어떨까요?")
                        .build();
                sendEmail(emailMessage);

        }
    }

    public void sendEmail(EmailMessage emailMessage) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            mimeMessageHelper.setTo(emailMessage.getTo()); // 메일 수신자
            mimeMessageHelper.setSubject(emailMessage.getSubject()); // 메일 제목
            mimeMessageHelper.setText(emailMessage.getMessage(), false); // 메일 본문 내용, html 여부
            javaMailSender.send(mimeMessage);
            log.info("Email sent successfully!");
        } catch (MessagingException e) {
            log.error("Failed to send email", e);
            throw new RuntimeException(e);
        }
    }


}
