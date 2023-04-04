package com.kwonjs.questioningmusseukgi.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kwonjs.questioningmusseukgi.question.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
