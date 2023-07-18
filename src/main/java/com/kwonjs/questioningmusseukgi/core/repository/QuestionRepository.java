package com.kwonjs.questioningmusseukgi.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kwonjs.questioningmusseukgi.core.domain.question.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
