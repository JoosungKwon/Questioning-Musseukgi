package com.kwonjs.questioningmusseukgi.core.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kwonjs.questioningmusseukgi.common.dto.ApiResponse;
import com.kwonjs.questioningmusseukgi.core.dto.EvaluateAnswerRequest;
import com.kwonjs.questioningmusseukgi.core.service.AnswerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/evaluate")
@RequiredArgsConstructor
public class AnswerController {

	private final AnswerService answerService;

	@PostMapping
	public ResponseEntity<ApiResponse<String>> evaluateAnswerFromWeb(
		@RequestBody EvaluateAnswerRequest request
	) {
		String evaluation = answerService.evaluate(request);

		return ApiResponse.ok(evaluation);
	}
}
