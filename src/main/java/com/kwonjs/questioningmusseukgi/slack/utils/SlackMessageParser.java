package com.kwonjs.questioningmusseukgi.slack.utils;

import static lombok.AccessLevel.*;

import com.kwonjs.questioningmusseukgi.slack.event.SlackMessage;
import com.slack.api.app_backend.interactive_components.payload.BlockActionPayload;
import com.slack.api.model.block.InputBlock;
import com.slack.api.model.block.SectionBlock;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class SlackMessageParser {

	public static SlackMessage parseMessageType(BlockActionPayload blockActionPayload) {

		SectionBlock sectionBlock = (SectionBlock) blockActionPayload.getMessage().getBlocks().get(1);
		InputBlock inputBlock = (InputBlock) blockActionPayload.getMessage().getBlocks().get(3);

		String type = blockActionPayload.getType();
		String userId = blockActionPayload.getUser().getId();
		String username = blockActionPayload.getUser().getUsername();
		String channelName = blockActionPayload.getChannel().getName();
		String channelId = blockActionPayload.getChannel().getId();
		String teamName = blockActionPayload.getTeam().getDomain();
		String actionId = blockActionPayload.getActions().get(0).getActionId();
		String responseUrl = blockActionPayload.getResponseUrl();
		String question = sectionBlock.getText().getText();
		String userAnswer = blockActionPayload
			.getState()
			.getValues()
			.get(inputBlock.getBlockId())
			.get("input")
			.getValue();

		return SlackMessage.builder()
			.type(type)
			.userId(userId)
			.username(username)
			.channelName(channelName)
			.channelId(channelId)
			.teamName(teamName)
			.actionId(actionId)
			.responseUrl(responseUrl)
			.question(question)
			.userAnswer(userAnswer)
			.build();
	}


}
