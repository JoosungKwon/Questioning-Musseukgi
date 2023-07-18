package com.kwonjs.questioningmusseukgi.common.dto;

import org.springframework.http.ResponseEntity;

public record ApiResponse<T> (
	T data
){
	public static <T> ResponseEntity<ApiResponse<T>> ok(T data) {
		return ResponseEntity.ok(new ApiResponse<>(data));
	}
}
