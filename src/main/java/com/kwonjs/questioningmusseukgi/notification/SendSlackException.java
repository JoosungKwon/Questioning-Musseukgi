package com.kwonjs.questioningmusseukgi.notification;

import static com.kwonjs.questioningmusseukgi.exception.ErrorCode.*;

import com.kwonjs.questioningmusseukgi.exception.ErrorCode;
import com.kwonjs.questioningmusseukgi.exception.ServiceException;

import lombok.Getter;

@Getter
public class SendSlackException extends ServiceException {

	private Exception e;
	private static final ErrorCode errorCode = SLACK_SEND_ERROR;

	public SendSlackException(Exception e) {
		super(errorCode);
		this.e = e;
	}
}
