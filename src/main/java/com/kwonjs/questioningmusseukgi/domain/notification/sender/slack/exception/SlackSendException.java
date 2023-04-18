package com.kwonjs.questioningmusseukgi.domain.notification.sender.slack.exception;

import com.kwonjs.questioningmusseukgi.global.exception.ErrorCode;
import com.kwonjs.questioningmusseukgi.global.exception.ServiceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SlackSendException extends ServiceException {

	private final String EXCEPTION_FORMAT = "address: {}";

	private static final ErrorCode ERROR_CODE = ErrorCode.SLACK_SEND_ERROR;

	public SlackSendException(String address) {
		super(ERROR_CODE);
		log.debug(EXCEPTION_FORMAT, address);
	}
}
