package com.kwonjs.questioningmusseukgi.domain.answer.dto;

public record EvaluateAnswerRequest(
	String channelId,
	String question,
	String answer
) {
}
