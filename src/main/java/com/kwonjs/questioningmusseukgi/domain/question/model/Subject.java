package com.kwonjs.questioningmusseukgi.domain.question.model;

import java.util.Arrays;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Subject {

	JAVA("java"),
	SPRING("spring"),
	OS("os"),
	NETWORK("network"),
	DATABASE("database"),
	DATA_STRUCTURE("dataStructure"),
	ALGORITHM("algorithm");

	private final String value;

	Subject(String subjectName) {
			this.value = subjectName;
	}

	@JsonCreator
	public static Subject of(String subjectName) {
		return Arrays.stream(Subject.values())
			.filter(value -> Objects.equals(value.getSubject(), subjectName.toLowerCase()))
			.findFirst()
			.orElseThrow();
	}

	@JsonValue
	public String getSubject() {
		return value;
	}
}
