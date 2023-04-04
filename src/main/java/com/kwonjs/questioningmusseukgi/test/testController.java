package com.kwonjs.questioningmusseukgi.test;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kwonjs.questioningmusseukgi.notification.NotificationService;
import com.kwonjs.questioningmusseukgi.question.dto.QuestionRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class testController {

	private final NotificationService notificationService;

	@GetMapping
	@ResponseStatus(OK)
	public void addQuestion() { // 수동 요청
		notificationService.sendToQuestionAtTime(LocalTime.now());
	}

}
