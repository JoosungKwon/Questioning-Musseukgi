package com.kwonjs.questioningmusseukgi.domain.notification.sender.slack;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kwonjs.questioningmusseukgi.domain.notification.sender.Sender;
import com.kwonjs.questioningmusseukgi.domain.question.model.Question;
import com.kwonjs.questioningmusseukgi.domain.user.model.User;
import com.kwonjs.questioningmusseukgi.global.common.config.SlackConfig;
import com.slack.api.app_backend.interactive_components.payload.BlockActionPayload;
import com.slack.api.model.block.LayoutBlock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class SlackSender implements Sender {

	private final String DISPLAY_MESSAGE = "머쓱이가 메시지를 보냈습니다!";
	private final String WAITING_MESSAGE = "잠시만 기다려주세요! 면접관 머쓱이가 답변을 평가하는 중입니다...(30초 가량 소요됩니다.)";

	private final SlackConfig slackConfig;
	private final SlackClient slackClient;
	private final SlackMessageBuilder slackMessageBuilder;

	public void send(User user, Question question) {
		String channelId = user.getChannel();

		sendTo(channelId, question.toTemplate());
	}

	public void sendTo(String channelId, String message) {

		List<LayoutBlock> blocks = slackMessageBuilder.buildAskFormat(message);

		slackClient.sendChatPostMessage(slackConfig.getOauthToken(), channelId, blocks, DISPLAY_MESSAGE);

		log.debug("Send ChatPostMessage to slack channelId: {}, message: {}", channelId, blocks);
	}

	public void reply(BlockActionPayload blockActionPayload, String answer, String evaluate){

		String responseUrl = blockActionPayload.getResponseUrl();

		List<LayoutBlock> originBlocks = blockActionPayload.getMessage().getBlocks();

		List<LayoutBlock> replyBlocks
			= slackMessageBuilder.buildReplyFormat(originBlocks, answer, evaluate);

		slackClient.sendReplyResponse(responseUrl, replyBlocks, true);

		log.debug("Send ReplyResponse to slack URL: {}, message: {}", responseUrl, replyBlocks);
	}

	public void sendWaitMessage(String responseUrl) {

		List<LayoutBlock> waitMessage =
			slackMessageBuilder.buildWaitMessageFormat(WAITING_MESSAGE);

		slackClient.sendReplyResponse(responseUrl, waitMessage,true);
	}
}


