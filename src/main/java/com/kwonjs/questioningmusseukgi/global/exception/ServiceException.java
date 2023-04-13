package com.kwonjs.questioningmusseukgi.global.exception;

import lombok.Getter;

@Getter
public abstract class ServiceException extends RuntimeException {

	private final ErrorCode errorCode;

	protected ServiceException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
}
