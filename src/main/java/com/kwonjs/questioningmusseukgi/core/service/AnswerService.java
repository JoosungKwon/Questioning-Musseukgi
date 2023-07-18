package com.kwonjs.questioningmusseukgi.core.service;

import org.springframework.stereotype.Service;

import com.kwonjs.questioningmusseukgi.core.domain.answer.Answer;
import com.kwonjs.questioningmusseukgi.core.dto.EvaluateAnswerRequest;
import com.kwonjs.questioningmusseukgi.core.repository.AnswerRepository;
import com.kwonjs.questioningmusseukgi.support.chatqpt.service.ChatGptService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnswerService {

	private final ChatGptService chatGptService;
	private final AnswerRepository answerRepository;

	private final String settingMessage =
			"""
			너는 15년차 시니어 개발자야
			그리고 지금 주니어 개발자를 면접보고 있는 면접관이야
			너는 지금 나한테
			질문: %s
			을 했어,
			그 질문에 나는
			답변: %s
			을 했어
			내 답변에 대해 구체적으로 평가해줘
			예를 들어 무엇이 부족했는지, 잘했는지, 몇 점 짜리 답변이었는지, 등
			그리고 평가 기준하고 모범 답안까지 알려줘
			""";

	public String evaluate(EvaluateAnswerRequest request) {
		return evaluate(request.channelId(), request.question(), request.answer());
	}

	public String evaluate(String channelId, String question, String userAnswer) {

		String gptAsking = String.format(settingMessage, question, userAnswer);
		String gptAnswer = chatGptService.sendTo(gptAsking);

		log.info("Asked ChatGPT \n Question({}) \n Got Answer({}).", gptAsking, gptAnswer);

		// 사용자 답변을 저장하는 로직 추가
		Answer answer = new Answer(channelId, userAnswer);
		answerRepository.save(answer);

		return gptAnswer;
	}
}


