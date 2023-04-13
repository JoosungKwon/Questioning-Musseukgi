package com.kwonjs.questioningmusseukgi.global.exception;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

	// Common
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C001", "서버 에러입니다."),
	INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C002", "잘못된 입력 값입니다."),
	MISSING_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C003", "인자가 부족합니다."),
	NOT_EXIST_API(HttpStatus.BAD_REQUEST, "C004", "요청 주소가 올바르지 않습니다."),
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "C005", "요청 메서드가 올바르지 않습니다."),
	HANDLE_ACCESS_DENIED(HttpStatus.FORBIDDEN, "C006", "접근 권한이 없습니다."),

	// User
	USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U001", "유저를 찾을 수 없습니다."),

	// Auth
	EXPIRED_TOKEN(HttpStatus.FORBIDDEN,"A001","만료된 토큰입니다."),
	INVALID_TOKEN(HttpStatus.FORBIDDEN,"A002","유효하지 않은 토큰입니다."),

	//Sender
	SLACK_SEND_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "S001", "슬랙 메시지 전송에 실패했습니다.");

	private final HttpStatus status;
	private final String code;
	private final String message;

	ErrorCode(HttpStatus status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}
