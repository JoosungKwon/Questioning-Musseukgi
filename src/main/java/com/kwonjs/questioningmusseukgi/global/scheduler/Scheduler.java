package com.kwonjs.questioningmusseukgi.global.scheduler;

import java.time.LocalTime;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.kwonjs.questioningmusseukgi.domain.notification.NotificationService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableAsync
@EnableScheduling
@RequiredArgsConstructor
public class Scheduler {

	private final NotificationService notificationService;

	@Async
	@Scheduled(cron = "0 */10 * * * *", zone = "Asia/Seoul")
	public void task() {
		notificationService.sendToQuestionAtTime(LocalTime.now());
	}

}
