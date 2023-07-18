package com.kwonjs.questioningmusseukgi.core.dto;

public record EvaluateAnswerRequest(
	String channelId,
	String question,
	String answer
) {
}
