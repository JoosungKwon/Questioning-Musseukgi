package com.kwonjs.questioningmusseukgi.slack.event;

import static org.springframework.http.MediaType.*;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
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

	@PostMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<EventResponse> evaluateAnswerFromSlack(
		@RequestBody MultiValueMap<String, Object> event) {

		log.info("Slack Event: {}", event);

		return ResponseEntity.ok(new EventResponse(String.valueOf(event.get("challenge"))));
	}


	protected record EventResponse(
		String challenge
	) {
	}
}
