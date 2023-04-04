// package com.kwonjs.questioningmusseukgi.question.model;
//
// import java.util.Arrays;
// import java.util.Objects;
//
// import javax.persistence.AttributeConverter;
// import javax.persistence.Converter;
//
// import com.fasterxml.jackson.annotation.JsonCreator;
// import com.fasterxml.jackson.annotation.JsonValue;
//
// public enum Subject1 {
//
// 	JAVA("JAVA"),
// 	SPRING("SPRING"),
// 	OS("OS"),
// 	NETWORK("NETWORK"),
// 	DATABASE("DATABASE"),
// 	DATA_STRUCTURE("DATA_STRUCTURE"),
// 	ALGORITHM("ALGORITHM"),
// 	ETC("ETC");
//
// 	private final String name;
//
// 	Subject(String subjectName) {
// 			this.name = subjectName;
// 	}
//
// 	@JsonCreator
// 	public static Subject of(String subjectName) {
// 		return Arrays.stream(Subject.values())
// 			.filter(value -> Objects.equals(value.getName(), subjectName.toUpperCase()))
// 			.findFirst()
// 			.orElseThrow();
// 	}
//
// 	@JsonValue
// 	public String getName() {
// 		return name;
// 	}
//
// 	@Converter
// 	public static class SubjectConverter implements AttributeConverter<Subject, String> {
//
// 		@Override
// 		public String convertToDatabaseColumn(Subject subject) {
// 			if (Objects.isNull(subject)) {
// 				return null;
// 			}
// 			return subject.getName();
// 		}
//
// 		@Override
// 		public Subject convertToEntityAttribute(String data) {
// 			if (Objects.isNull(data)) {
// 				return null;
// 			}
// 			return Subject.find(dbData); // find는 미리 정의된 함수. 없으면 Exception.
// 		}
// 	}
// }
