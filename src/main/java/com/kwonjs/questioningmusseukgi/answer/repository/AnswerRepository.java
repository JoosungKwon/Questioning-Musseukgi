package com.kwonjs.questioningmusseukgi.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kwonjs.questioningmusseukgi.answer.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
