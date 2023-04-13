package com.kwonjs.questioningmusseukgi.domain.notification.sender;

import com.kwonjs.questioningmusseukgi.domain.question.model.Question;
import com.kwonjs.questioningmusseukgi.domain.user.model.User;

public interface Sender {
	void sendTo(User user, Question question);
}