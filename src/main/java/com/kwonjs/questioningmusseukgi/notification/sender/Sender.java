package com.kwonjs.questioningmusseukgi.notification.sender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kwonjs.questioningmusseukgi.question.model.Question;
import com.kwonjs.questioningmusseukgi.user.model.User;

public interface Sender {
	void sendTo(User user, Question question) throws JsonProcessingException;
}
