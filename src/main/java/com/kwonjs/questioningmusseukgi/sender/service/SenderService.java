package com.kwonjs.questioningmusseukgi.sender.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.kwonjs.questioningmusseukgi.question.model.Question;
import com.kwonjs.questioningmusseukgi.sender.model.Sender;
import com.kwonjs.questioningmusseukgi.user.model.User;

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
