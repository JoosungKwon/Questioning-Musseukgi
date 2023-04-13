package com.kwonjs.questioningmusseukgi.domain.notification.exception;

import com.kwonjs.questioningmusseukgi.global.exception.ErrorCode;
import com.kwonjs.questioningmusseukgi.global.exception.ServiceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SendSlackException extends ServiceException {

	private final String EXCEPTION_FORMAT = "User: {}, webhookUrl: {}, channel: {}";

	private static final ErrorCode ERROR_CODE = ErrorCode.SLACK_SEND_ERROR;

	public SendSlackException(String... param) {
		super(ERROR_CODE);
		log.debug(EXCEPTION_FORMAT, param);
	}
}