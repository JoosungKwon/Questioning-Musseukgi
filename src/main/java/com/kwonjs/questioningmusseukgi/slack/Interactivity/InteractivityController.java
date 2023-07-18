package com.kwonjs.questioningmusseukgi.slack.Interactivity;

import java.lang.reflect.Type;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.reflect.TypeToken;
import com.kwonjs.questioningmusseukgi.answer.service.AnswerService;
import com.kwonjs.questioningmusseukgi.slack.event.SlackMessage;
import com.kwonjs.questioningmusseukgi.slack.service.SlackService;
import com.kwonjs.questioningmusseukgi.slack.utils.SlackMessageMapper;
import com.kwonjs.questioningmusseukgi.slack.utils.SlackMessageParser;
import com.slack.api.app_backend.interactive_components.payload.BlockActionPayload;
import com.slack.api.model.block.LayoutBlock;
import com.slack.api.util.json.GsonFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/interactivity")
@RequiredArgsConstructor
public class InteractivityController {

	// TODO: 슬랙 이벤트 처리 컨트롤러 와 평가 기능을 담당하는 서비스 분리하기
	private final AnswerService answerService;
	private final SlackService slackService;

	@PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void evaluateAnswerFromSlack(@RequestParam String payload) {

		Type type = new TypeToken<Map<String, Object>>() {}.getType();
		Map<String, Object> payloadMap = GsonFactory.createSnakeCase().fromJson(payload, type);

		String responseUrl = String.valueOf(payloadMap.get("response_url"));

		// Json String -> BlockActionPayload Parse
		BlockActionPayload blockActionPayload = SlackMessageMapper.covertBlockActionPayload(payload);

		if ("delete".equals(String.valueOf(payloadMap.get("callback_id")))) {
			slackService.deleteMessage(blockActionPayload);
			return;
		}

		log.info("Slack Action Payload: {}", blockActionPayload);

		// GPT에게 답변을 받아서 보내는 과정이 길기 때문에 대기 중 메시지 먼저 응답
		slackService.sendWaitMessage(responseUrl);

		LayoutBlock layoutBlock = blockActionPayload.getMessage().getBlocks().get(3);

		if (layoutBlock instanceof com.slack.api.model.block.SectionBlock) {
			slackService.sendMessage(blockActionPayload.getResponseUrl(), "이미 답변된 평가입니다.", false);
		}

		// Parsing Slack Message Data
		SlackMessage slackMessage = SlackMessageParser.parseMessageType(blockActionPayload);
		log.info("Slack Message: {}", slackMessage);

		// getAnswerFromGPT(slackMessage);
		String evaluation = answerService.evaluate(slackMessage.getChannelId(), slackMessage.getQuestion(), slackMessage.getUserAnswer());

		slackService.reply(blockActionPayload, slackMessage.getUserAnswer(), evaluation);
	}
}
