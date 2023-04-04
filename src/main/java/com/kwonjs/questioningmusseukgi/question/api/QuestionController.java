package com.kwonjs.questioningmusseukgi.question.api;

import static com.kwonjs.questioningmusseukgi.question.dto.QuestionRequest.*;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kwonjs.questioningmusseukgi.question.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

	private QuestionService questionService;

	/**
	 * 외부에서 문제를 추가하는 기능 (관리자 기능)
	 */

	@PostMapping(consumes = APPLICATION_JSON_VALUE)
	@ResponseStatus(CREATED)
	public void addQuestion(AddRequest request) {
		questionService.add(request);
	}

	/**
	 * 문제를 삭제하는 기능 (관리자 기능)
	 */

	@DeleteMapping(consumes = APPLICATION_JSON_VALUE)
	@ResponseStatus(NO_CONTENT)
	public void deleteQuestion(DeleteRequest request) {
		questionService.delete(request);
	}

}
