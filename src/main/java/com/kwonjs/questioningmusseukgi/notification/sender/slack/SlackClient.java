package com.kwonjs.questioningmusseukgi.notification.sender.slack;

import java.net.URI;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Client", url = "URL")
public interface SlackClient {

	@PostMapping
	void sendSlack(
		URI uri,
		@RequestBody String payload
	);

}