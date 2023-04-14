package com.kwonjs.questioningmusseukgi.domain.notification.api;

import static org.springframework.http.HttpStatus.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kwonjs.questioningmusseukgi.domain.notification.NotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notification")
public class NotificationController {

	private final NotificationService notificationService;

	@GetMapping("/start")
	@ResponseStatus(OK)
	public void startNotificationOnce() { // 스케줄러 수동 동작 임시 메서드 -> 추후에는 사람에 맞게 해당 사람에게 보낼 수 있도록 수정
		notificationService.sendToQuestionAtTime();
	}

}
