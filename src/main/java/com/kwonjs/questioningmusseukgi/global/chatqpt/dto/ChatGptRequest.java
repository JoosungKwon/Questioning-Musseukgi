package com.kwonjs.questioningmusseukgi.global.chatqpt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public record ChatGptRequest(
	String model,
	String prompt,
	@JsonProperty("max_tokens")
	Integer maxTokens,
	Double temperature,
	@JsonProperty("top_p")
	Double topP
) {
}
