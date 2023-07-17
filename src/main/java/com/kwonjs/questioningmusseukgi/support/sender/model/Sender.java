package com.kwonjs.questioningmusseukgi.support.sender.model;

import com.kwonjs.questioningmusseukgi.core.domain.question.Question;
import com.kwonjs.questioningmusseukgi.user.model.User;

public interface Sender {
	void send(User user, Question question);
}
