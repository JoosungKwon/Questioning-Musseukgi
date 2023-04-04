package com.kwonjs.questioningmusseukgi.question.dto;

import com.kwonjs.questioningmusseukgi.question.model.Question;
import com.kwonjs.questioningmusseukgi.question.model.Subject;

public class QuestionRequest {

	public record AddRequest(
		Subject subject,
		String content
	) {
		public Question toEntity() {
			return new Question(subject, content);
		}
	}

	public record DeleteRequest(Long questionId) {
	}

}
