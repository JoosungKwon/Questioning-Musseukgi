package com.kwonjs.questioningmusseukgi.common.dto;

import com.kwonjs.questioningmusseukgi.common.exception.ErrorCode;

public record ErrorResponse(
	String code,
	String message
) {

	public static ErrorResponse of(ErrorCode code) {
		return new ErrorResponse(code.getCode(), code.getMessage());
	}

}
