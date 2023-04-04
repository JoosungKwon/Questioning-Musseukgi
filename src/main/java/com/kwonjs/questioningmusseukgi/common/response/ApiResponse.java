package com.kwonjs.questioningmusseukgi.common.response;

public record ApiResponse<T> (
	T data
){

}
