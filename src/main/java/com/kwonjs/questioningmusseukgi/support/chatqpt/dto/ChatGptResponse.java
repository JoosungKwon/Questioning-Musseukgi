package com.kwonjs.questioningmusseukgi.support.chatqpt.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public record ChatGptResponse(
	String id,
	String object,
	LocalDate created,
	String model,
	List<Choice> choices
) {
	@Builder
	public record Choice(
		String text,
		Integer index,
		@JsonProperty("finish_reason")
		String finishReason
	) {
	}
}


