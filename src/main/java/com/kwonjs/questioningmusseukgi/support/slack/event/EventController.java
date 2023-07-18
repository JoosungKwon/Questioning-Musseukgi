package com.kwonjs.questioningmusseukgi.support.slack.event;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

	@PostMapping
	public ResponseEntity<EventResponse> evaluateAnswerFromSlack(
		@RequestBody String event) {

		log.info("Slack Event: {}", event);
		// event.getFirst("challenge")

		return ResponseEntity.ok(new EventResponse(event));
	}


	protected record EventResponse(
		String challenge
	) {
	}
}
