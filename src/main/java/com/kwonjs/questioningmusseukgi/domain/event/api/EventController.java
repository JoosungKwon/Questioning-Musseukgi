package com.kwonjs.questioningmusseukgi.domain.event.api;

import static org.springframework.http.HttpStatus.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kwonjs.questioningmusseukgi.domain.answer.service.AnswerService;
import com.kwonjs.questioningmusseukgi.domain.notification.sender.slack.SlackSender;
import com.slack.api.app_backend.interactive_components.payload.BlockActionPayload;
import com.slack.api.model.block.InputBlock;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.util.json.GsonFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

	// TODO: 슬랙 이벤트 처리 컨트롤러 와 평가 기능을 담당하는 서비스 분리하기
	private final AnswerService answerService;
	private final SlackSender slackSender;

	@PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseStatus(OK)
	public void evaluateAnswerFromSlack(@RequestParam String payload) {
		// Json String -> BlockActionPayload Parse
		BlockActionPayload blockActionPayload =
			GsonFactory.createSnakeCase()
				.fromJson(payload, BlockActionPayload.class);

		log.debug("Slack Action Payload: {}", blockActionPayload);

		// GPT에게 답변을 받아서 보내는 과정이 길기 때문에 대기 중 메시지 먼저 응답
		slackSender.sendWaitMessage(blockActionPayload.getResponseUrl());

		// Parsing Slack Message Data
		// TODO: SlackMessageParser 추가하기
		// TODO: 조건 에 따라 다른 파싱 과정이 필요함
		SectionBlock sectionBlock = (SectionBlock) blockActionPayload.getMessage().getBlocks().get(1);
		InputBlock inputBlock = (InputBlock) blockActionPayload.getMessage().getBlocks().get(3);

		String channelId = blockActionPayload.getChannel().getId();
		String question = sectionBlock.getText().getText();
		String userAnswer = blockActionPayload
			.getState()
			.getValues()
			.get(inputBlock.getBlockId())
			.get("input")
			.getValue();

		String evaluation = answerService.evaluate(channelId, question, userAnswer);

		slackSender.reply(blockActionPayload, userAnswer, evaluation);
	}
}
