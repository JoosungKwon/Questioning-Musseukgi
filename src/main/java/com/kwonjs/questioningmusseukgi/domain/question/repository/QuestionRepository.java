package com.kwonjs.questioningmusseukgi.domain.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kwonjs.questioningmusseukgi.domain.question.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
