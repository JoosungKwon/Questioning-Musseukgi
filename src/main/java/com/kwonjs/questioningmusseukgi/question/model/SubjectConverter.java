package com.kwonjs.questioningmusseukgi.question.model;

import java.util.Objects;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SubjectConverter implements AttributeConverter<Subject, String> {

	@Override
	public String convertToDatabaseColumn(Subject subject) {
		if (Objects.isNull(subject)) {
			return null;
		}
		return subject.getName();
	}

	@Override
	public Subject convertToEntityAttribute(String data) {
		if (Objects.isNull(data)) {
			return null;
		}
		return Subject.of(data);
	}
}
