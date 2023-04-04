package com.kwonjs.questioningmusseukgi.question.generater.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.kwonjs.questioningmusseukgi.question.generater.model.Generator;
import com.kwonjs.questioningmusseukgi.question.model.Question;
import com.kwonjs.questioningmusseukgi.user.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GenerateService {

	private final Map<String, Generator> generatorMap;

	public GenerateService(Map<String, Generator> generatorMap) {
		this.generatorMap = generatorMap;
	}

	public Question generate(User user) { // TODO: 추후에 사용자 설정에 맞춰서 질문을 가져올 수 있도록 확장 및 알고리즘 변경
		log.info("generatorMap: Key - {}, value - {}", generatorMap.keySet(), generatorMap.values());
		Generator generator = generatorMap.get(user.getGeneratorType() + "Generator");
		return generator.generate();
	}

}
