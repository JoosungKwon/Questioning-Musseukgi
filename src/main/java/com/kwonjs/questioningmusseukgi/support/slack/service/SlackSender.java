package com.kwonjs.questioningmusseukgi.support.slack.service;

import org.springframework.stereotype.Component;

import com.kwonjs.questioningmusseukgi.core.domain.question.Question;
import com.kwonjs.questioningmusseukgi.support.sender.model.Sender;
import com.kwonjs.questioningmusseukgi.user.model.User;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class SlackSender implements Sender {

	private final SlackService slackService;

	@Override
	public void send(User user, Question question) {
		String channelId = user.getChannel();

		slackService.sendTo(channelId, question.toTemplate());
	}
}
