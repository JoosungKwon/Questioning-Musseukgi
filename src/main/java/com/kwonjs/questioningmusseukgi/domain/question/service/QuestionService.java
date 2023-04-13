package com.kwonjs.questioningmusseukgi.domain.question.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kwonjs.questioningmusseukgi.domain.question.generater.Generator;
import com.kwonjs.questioningmusseukgi.domain.question.model.Question;
import com.kwonjs.questioningmusseukgi.domain.user.model.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionService {

	private final Map<String, Generator> generatorMap;

	public Question generateBy(User user) { // TODO: 추후에 사용자 설정에 맞춰서 질문을 가져올 수 있도록 확장 및 알고리즘 변경
		Generator generator = generatorMap.get(user.getGeneratorType() + "Generator");

		log.info("start generate question By {}", generator.getClass().getSimpleName());

		Question question = generator.generate();

		log.info("finish generate question : {}", question);

		return question;
	}
}
