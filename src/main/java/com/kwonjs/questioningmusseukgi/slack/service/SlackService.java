package com.kwonjs.questioningmusseukgi.slack.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kwonjs.questioningmusseukgi.common.config.SlackConfig;
import com.kwonjs.questioningmusseukgi.slack.client.SlackClient;
import com.kwonjs.questioningmusseukgi.slack.utils.SlackMessageBuilder;
import com.slack.api.app_backend.interactive_components.payload.BlockActionPayload;
import com.slack.api.model.block.LayoutBlock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SlackService {

	private final String DISPLAY_MESSAGE = "머쓱이가 메시지를 보냈습니다!";
	private final String WAITING_MESSAGE = "잠시만 기다려주세요! 면접관 머쓱이가 답변을 평가하는 중입니다...(30초 가량 소요됩니다.)";

	private final SlackConfig slackConfig;
	private final SlackClient slackClient;

	public void sendTo(String channelId, String message) {

		List<LayoutBlock> blocks = SlackMessageBuilder.buildAskFormat(message);

		slackClient.sendChatPostMessage(slackConfig.getOauthToken(), channelId, blocks, DISPLAY_MESSAGE);

		log.info("Send ChatPostMessage to slack channelId: {}, message: {}", channelId, blocks);
	}

	public void reply(BlockActionPayload blockActionPayload, String answer, String evaluate){

		String responseUrl = blockActionPayload.getResponseUrl();

		List<LayoutBlock> originBlocks = blockActionPayload.getMessage().getBlocks();

		List<LayoutBlock> replyBlocks
			= SlackMessageBuilder.buildReplyFormat(originBlocks, answer, evaluate);

		slackClient.sendReplyResponse(responseUrl, replyBlocks, true);

		log.info("Send ReplyResponse to slack URL: {}, message: {}", responseUrl, replyBlocks);
	}

	public void sendWaitMessage(String responseUrl) {
		sendMessage(responseUrl, WAITING_MESSAGE, true);
	}

	public void sendMessage(String responseUrl, String message, boolean replaceFlag) {

		List<LayoutBlock> blocks =
			SlackMessageBuilder.buildWaitMessageFormat(message);

		slackClient.sendReplyResponse(responseUrl, blocks, replaceFlag);
		log.info("Send WaitMessage to slack URL: {}, message: {}", responseUrl, blocks);
	}
}


