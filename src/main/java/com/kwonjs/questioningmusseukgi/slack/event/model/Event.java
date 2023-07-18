package com.kwonjs.questioningmusseukgi.slack.event.model;

public record Event(
	String token,
	String challenge,
	String type
) {
}
