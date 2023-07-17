package com.kwonjs.questioningmusseukgi.support.slack.event;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class SlackMessage {

	private final String type;
	private final String userId;
	private final String username;
	private final String channelId;
	private final String channelName;
	private final String teamName;
	private final String actionId;
	private final String responseUrl;
	private final String question;
	private final String userAnswer;

	@Builder
	public SlackMessage(String type,
		String userId, String username, String channelId, String channelName,
		String teamName, String actionId, String responseUrl,
		String question, String userAnswer) {
		this.type = type;
		this.userId = userId;
		this.username = username;
		this.channelId = channelId;
		this.channelName = channelName;
		this.teamName = teamName;
		this.actionId = actionId;
		this.responseUrl = responseUrl;
		this.question = question;
		this.userAnswer = userAnswer;
	}
}