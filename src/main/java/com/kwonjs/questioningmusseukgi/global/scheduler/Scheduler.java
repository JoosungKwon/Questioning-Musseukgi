package com.kwonjs.questioningmusseukgi.global.scheduler;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableAsync
@EnableScheduling
@RequiredArgsConstructor
public class Scheduler {

	@Async
	@Scheduled(cron = "0 */10 * * * *", zone = "Asia/Seoul")
	public void task() {

	}

}
