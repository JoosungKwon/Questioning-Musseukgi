package com.kwonjs.questioningmusseukgi.support.slack.client;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kwonjs.questioningmusseukgi.support.slack.exception.SlackSendException;
import com.slack.api.Slack;
import com.slack.api.app_backend.interactive_components.ActionResponseSender;
import com.slack.api.app_backend.interactive_components.response.ActionResponse;
import com.slack.api.model.block.LayoutBlock;

@Component
public class SlackClient {

	private final Slack slack = Slack.getInstance();

	public void sendChatPostMessage(String oauthToken, String channelId,
		List<LayoutBlock> messageBlocks, String text
	) {
		try {
			slack.methodsAsync(oauthToken)
				.chatPostMessage(builder -> builder
					.channel(channelId)
					.text(text)
					.blocks(messageBlocks));
		} catch (Exception e) {
			throw new SlackSendException(channelId);
		}

	}

	public void sendReplyResponse(String requestUrl, List<LayoutBlock> messageBlocks,
		boolean replaceFlag) {

		ActionResponseSender replySender = new ActionResponseSender(slack);

		ActionResponse response =
			ActionResponse.builder()
				.replaceOriginal(replaceFlag)
				.blocks(messageBlocks)
				.build();

		try {
			replySender.send(requestUrl, response);
		} catch (Exception e) {
			throw new SlackSendException(requestUrl);
		}

	}
}
