package com.kwonjs.questioningmusseukgi.question.model;

import java.util.Arrays;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Subject {

	JAVA, SPRING, OS, NETWORK, DATABASE, DATA_STRUCTURE, ALGORITHM, INFRA, GIT, ETC;

	@JsonCreator
	public static Subject of(String subjectName) {
		return Arrays.stream(Subject.values())
			.filter(value -> Objects.equals(value.name(), subjectName.toUpperCase()))
			.findFirst()
			.orElseThrow();
	}

	@JsonValue
	public String getName() {
		return this.name();
	}

}

