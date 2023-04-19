package com.kwonjs.questioningmusseukgi.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@ConstructorBinding
@ConfigurationProperties("openai")
public final class ChatGptConfig {
	private final String apiKey;
	private final String requestUrl;
	private final String model;
	private final Integer maxToken;
	private final Double temperature;
	private final Double topP;
}