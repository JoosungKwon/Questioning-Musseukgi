package com.kwonjs.questioningmusseukgi.domain.answer.model;

import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import javax.persistence.Entity;
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
@SQLDelete(sql = "UPDATE answer set deleted = true where id=?")
public class Answer {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	private String channelId;

	private String content;

	private boolean deleted;

	public Answer(String channelId, String content) {
		this.channelId = channelId;
		this.content = content;
	}
}

