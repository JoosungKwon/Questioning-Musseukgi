package com.kwonjs.questioningmusseukgi.domain.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kwonjs.questioningmusseukgi.domain.answer.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
