package com.kwonjs.questioningmusseukgi.core.domain.question;

import static javax.persistence.EnumType.*;
import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE question set deleted = true where id=?")
public class Question {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Enumerated(STRING)
	private Subject subject;

	private String content;

	private boolean deleted;

	public Question(Subject subject, String content) {
		this.subject = subject;
		this.content = content;
	}

	public String toTemplate() {
		return String.format("(%s) %s", subject, content);
	}
}
