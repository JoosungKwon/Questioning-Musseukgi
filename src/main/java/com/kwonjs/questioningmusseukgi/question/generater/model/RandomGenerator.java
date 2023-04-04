package com.kwonjs.questioningmusseukgi.question.generater.model;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.kwonjs.questioningmusseukgi.question.model.Question;
import com.kwonjs.questioningmusseukgi.question.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RandomGenerator implements Generator { // 랜덤한 번호를 생성하는 클래스

	private final QuestionRepository questionRepository;
	private final Random random = new Random();

	@Override
	public Question generate() {

		List<Question> questions = questionRepository.findAll();

		int randomIndex = random.nextInt(questions.size());

		Question randomQuestion = questions.get(randomIndex);

		return randomQuestion;
	}

}
