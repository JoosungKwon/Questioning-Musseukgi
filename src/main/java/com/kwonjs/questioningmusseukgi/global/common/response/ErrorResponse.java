package com.kwonjs.questioningmusseukgi.global.common.response;

import com.kwonjs.questioningmusseukgi.global.exception.ErrorCode;

public record ErrorResponse(
	String code,
	String message
) {

	public static ErrorResponse of(ErrorCode code) {
		return new ErrorResponse(code.getCode(), code.getMessage());
	}

}
