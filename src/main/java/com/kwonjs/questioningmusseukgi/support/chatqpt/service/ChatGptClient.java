package com.kwonjs.questioningmusseukgi.support.chatqpt.service;

import java.net.URI;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.kwonjs.questioningmusseukgi.support.chatqpt.dto.ChatGptRequest;
import com.kwonjs.questioningmusseukgi.support.chatqpt.dto.ChatGptResponse;

@FeignClient(name = "ChatGptClient", url = "URL")
public interface ChatGptClient {

	@PostMapping
	ChatGptResponse sendByPost(
		URI uri,
		@RequestHeader HttpHeaders headers,
		@RequestBody ChatGptRequest body
	);

}
