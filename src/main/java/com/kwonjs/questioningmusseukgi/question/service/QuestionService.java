package com.kwonjs.questioningmusseukgi.question.service;

import static com.kwonjs.questioningmusseukgi.question.dto.QuestionRequest.*;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kwonjs.questioningmusseukgi.question.dto.QuestionRequest.AddRequest;
import com.kwonjs.questioningmusseukgi.question.generater.service.GenerateService;
import com.kwonjs.questioningmusseukgi.question.model.Question;
import com.kwonjs.questioningmusseukgi.question.repository.QuestionRepository;
import com.kwonjs.questioningmusseukgi.user.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {

	private final QuestionRepository questionRepository;
	private final GenerateService generateService;

	public void add(AddRequest request) {
		questionRepository.save(request.toEntity());
	}

	public void delete(DeleteRequest request) {
		questionRepository.findById(request.questionId())
			.ifPresent(questionRepository::delete);
	}

	public Question getBy(User user) {
		return generateService.generate(user);
	}
}
