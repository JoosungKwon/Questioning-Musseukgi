package com.kwonjs.questioningmusseukgi.sender.model;

import com.kwonjs.questioningmusseukgi.question.model.Question;
import com.kwonjs.questioningmusseukgi.user.model.User;

public interface Sender {
	void send(User user, Question question);
}
