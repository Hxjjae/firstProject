package com.green.firstproject.mail;


import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private final EmailService emailService;
    private final EmailMessage emailMessage;
//
//    @Scheduled(cron = "0 30 18 * * 1")
//    public void sendMail() {
//        emailService.sendMail(emailMessage);
//    }
@Scheduled(cron = "0 30 18 ? * 1") // 매주 월요일 오후 6시 30분에 실행
public void sendEmail() {
    emailService.sendEmail(emailMessage);
}
}
