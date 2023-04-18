package com.kwonjs.questioningmusseukgi.global.common.response;

import org.springframework.http.ResponseEntity;

public record ApiResponse<T> (
	T data
){
	public static <T> ResponseEntity<ApiResponse<T>> ok(T data) {
		return ResponseEntity.ok(new ApiResponse<>(data));
	}
}
