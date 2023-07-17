package com.kwonjs.questioningmusseukgi.core.domain.answer;

public class Result {

	private final int answer;
	private final int score;

	public Result(int answer, int score) {
		this.answer = answer;
		this.score = score;
	}

	public int getAnswer() {
		return answer;
	}

	public int getScore() {
		return score;
	}

}
