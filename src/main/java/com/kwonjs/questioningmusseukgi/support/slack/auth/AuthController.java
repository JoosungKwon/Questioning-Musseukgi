package com.kwonjs.questioningmusseukgi.support.slack.auth;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.kwonjs.questioningmusseukgi.config.etc.SlackConfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/slack")
@RequiredArgsConstructor
public class AuthController {

	private final SlackConfig slackConfig;

	@GetMapping("/auth")
	public void install(HttpServletResponse response) throws IOException {

		String redirectUri = slackConfig.getRedirectUri();
		log.info("Redirect URI: {}", redirectUri);
		String uri = UriComponentsBuilder.fromUriString(redirectUri)
			.queryParam("client_id", slackConfig.getClientId())
			.queryParam("client_secret", slackConfig.getClientSecret())
			.queryParam("scope", String.join(",", slackConfig.getScopes()))
			.build().toUriString();

		response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		log.info("Target URI: {}", uri);
		response.sendRedirect(uri);
	}
}
