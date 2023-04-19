package com.kwonjs.questioningmusseukgi.answer.dto;

public record EvaluateAnswerRequest(
	String channelId,
	String question,
	String answer
) {
}
