package com.kwonjs.questioningmusseukgi.common.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "slack")
public final class SlackConfig {
	private final String oauthToken;
	private final String clientId;
	private final String clientSecret;
	private final String redirectUri;
	private final List<String> scopes;
}