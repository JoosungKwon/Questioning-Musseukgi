package com.kwonjs.questioningmusseukgi.domain.notification.sender.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.kwonjs.questioningmusseukgi.domain.notification.sender.Sender;
import com.kwonjs.questioningmusseukgi.domain.question.model.Question;
import com.kwonjs.questioningmusseukgi.domain.user.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SenderService {

	private final Map<String, Sender> senderProvider;

	public void send(User user, Question question) {
		String senderName = user.getSenderName();
		Sender sender = senderProvider.get(senderName + "Sender");
		sender.send(user, question);
	}
}
