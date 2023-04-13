package com.kwonjs.questioningmusseukgi.domain.notification.sender.slack;

import java.io.IOException;
import java.net.URI;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kwonjs.questioningmusseukgi.domain.notification.exception.SendSlackException;
import com.kwonjs.questioningmusseukgi.domain.question.model.Question;
import com.kwonjs.questioningmusseukgi.domain.user.model.User;
import com.kwonjs.questioningmusseukgi.domain.notification.sender.Sender;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class SlackSender implements Sender {

	private final SlackClient client;
	private final ObjectMapper objectMapper;

	public void sendTo(User user, Question question){

		String webhookUrl = user.getSlackWebhookUrl();
		String channel = user.getChannel();

		log.info("Send to slack webhookUrl: {}, channel: {}", webhookUrl, channel);
		Payload payload = new Payload(user.getMusseukgiName(), user.getIconEmoji(), channel, question.toTemplate());
		log.info("Payload: {}", payload);


		try {
			client.send(URI.create(webhookUrl), objectMapper.writeValueAsString(payload));
		} catch (IOException e) {
			log.debug("IOException : {}", e.getMessage());
			throw new SendSlackException(user.toString(), webhookUrl, channel);
		}

	}

	@ToString
	@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
	@RequiredArgsConstructor
	class Payload {
		private final String username;
		private final String iconEmoji;
		private final String channel;
		private final String text;
	}

}


