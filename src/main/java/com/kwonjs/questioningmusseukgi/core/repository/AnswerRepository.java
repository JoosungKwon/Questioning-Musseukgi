package com.kwonjs.questioningmusseukgi.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kwonjs.questioningmusseukgi.core.domain.answer.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
