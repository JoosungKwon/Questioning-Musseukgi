package com.kwonjs.questioningmusseukgi.common.response;

import com.kwonjs.questioningmusseukgi.exception.ErrorCode;

public record ErrorResponse(
	String code,
	String message
) {

	public static ErrorResponse of(ErrorCode code) {
		return new ErrorResponse(code.getCode(), code.getMessage());
	}

}
