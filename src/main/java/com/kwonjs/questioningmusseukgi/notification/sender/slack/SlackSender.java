package com.kwonjs.questioningmusseukgi.notification.sender.slack;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kwonjs.questioningmusseukgi.notification.sender.Sender;
import com.kwonjs.questioningmusseukgi.question.model.Question;
import com.kwonjs.questioningmusseukgi.user.model.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class SlackSender implements Sender {

	private final SlackClient client;
	private final ObjectMapper objectMapper;

	@Value("${slack.icon-emoji}") private String DEFAULT_ICON_EMOJI;
	@Value("${slack.bot-name}") private String DEFAULT_BOT_NAME;

	public void sendTo(User user, Question question) throws JsonProcessingException {
		String webhookUrl = user.getSlackWebhookUrl();
		String channel = user.getChannel();
		log.info("DEFAULT_ICON_EMOJI: {}, DEFAULT_BOT_NAME: {}", DEFAULT_ICON_EMOJI, DEFAULT_BOT_NAME);
		log.info("Send to slack webhookUrl: {}, channel: {}", webhookUrl, channel);
		Payload payload = new Payload(user.getMusseukgiName(), ":thx_mussg:", channel, question.toTemplate());
		client.sendSlack(URI.create(webhookUrl), objectMapper.writeValueAsString(payload));
	}

	@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
	@RequiredArgsConstructor
	class Payload {
		private final String username;
		@JsonProperty("icon_emoji")
		private final String iconEmoji;
		private final String channel;
		private final String text;
	}

}


