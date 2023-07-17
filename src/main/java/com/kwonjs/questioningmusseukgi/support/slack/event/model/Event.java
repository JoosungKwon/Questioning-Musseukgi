package com.kwonjs.questioningmusseukgi.support.slack.event.model;

public record Event(
	String token,
	String challenge,
	String type
) {
}
