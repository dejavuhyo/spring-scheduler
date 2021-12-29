package com.example.scheduler.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheculeJob {

    // 매초 실행, 기본값 1초
    @Scheduled(cron = "${cron.expression:0/1 * * * * ?}", zone = "Asia/Seoul")
    public void cronExpression() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatedNow = now.format(dateTimeFormatter);
        System.out.println("Using Cron Expression: " + formatedNow);
    }

    // 5초마다 실행, 기본값 1초
    @Scheduled(fixedDelayString = "${fixed.delay:1000}", zone = "Asia/Seoul")
    public void fixedDelay() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatedNow = now.format(dateTimeFormatter);
        System.out.println("Using Fixed Delay: " + formatedNow);
    }

}
