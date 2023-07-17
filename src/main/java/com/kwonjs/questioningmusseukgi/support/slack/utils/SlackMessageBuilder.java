package com.kwonjs.questioningmusseukgi.support.slack.utils;

import static com.slack.api.model.block.Blocks.*;
import static com.slack.api.model.block.composition.BlockCompositions.*;
import static com.slack.api.model.block.element.BlockElements.*;
import static lombok.AccessLevel.*;

import java.util.ArrayList;
import java.util.List;

import com.slack.api.model.block.LayoutBlock;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class SlackMessageBuilder {

	private static final String DEFAULT_HEADER_CONTENT = " :yes_mussg: 안녕! 나는 머쓱이라고 해";
	private static final String DEFAULT_INPUT_LABEL = "답변을 입력해주세요.";
	private static final String ACTION_ID_INPUT = "input";
	private static final String ACTION_ID_ANSWER = "answer";

	// TODO: 어떻게하면 메시지 포맷을 추상화할 수 있을지 고민이 필요함떠
	public static List<LayoutBlock> buildAskFormat(String message) {

		List<LayoutBlock> messageFormat = new ArrayList<>();

		// 0. 헤더
		messageFormat.add(
			header(header -> header
				.text(plainText(pt -> pt
					.text(DEFAULT_HEADER_CONTENT).emoji(true)))));

		// 1. 질문 (내용)
		messageFormat.add(1, section(section -> section
			.text(plainText(pt -> pt
				.text("질문" + "\n" + message)
				.emoji(true)))));

		// 2. Action과 텍스트를 구분하기 위한 Divider 입니다.
		messageFormat.add(divider());

		// 3. 답변창 (ActionBlock 답변을 보낼 수 있는 창)
		messageFormat.add(
			input(i -> i
				.element(plainTextInput(pti -> pti
					.actionId(ACTION_ID_INPUT).multiline(true)
				))
				.label(plainText(pt -> pt
					.text(DEFAULT_INPUT_LABEL).emoji(true)))
			)
		);

		// 4. 제출 버튼
		messageFormat.add(
			actions(actions -> actions
				.elements(asElements(
					button(b -> b
						.text(plainText(pt -> pt
							.text("답변하기").emoji(true)))
						.actionId(ACTION_ID_ANSWER))
				))
			)
		);

		return messageFormat;
	}

	public static List<LayoutBlock> buildReplyFormat(List<LayoutBlock> originBlocks,
		String answer, String evaluate) {

		originBlocks.remove(4);
		originBlocks.remove(3);

		originBlocks.add(section(section -> section
			.text(plainText(pt -> pt
				.text("답변" + "\n" +answer)
				.emoji(true)))));

		originBlocks.add(divider());

		originBlocks.add(section(section -> section
			.text(plainText(pt -> pt
				.text("평가" + "\n" + evaluate)
				.emoji(true)))));

		return originBlocks;
	}

	public static List<LayoutBlock> buildDeleteFormat(List<LayoutBlock> originBlocks) {

		originBlocks.clear();

		originBlocks.add(section(section -> section
			.text(plainText(pt -> pt
				.text("메시지가 삭제되었습니다.")
				.emoji(true)))));

		return originBlocks;
	}

	public static List<LayoutBlock> buildWaitMessageFormat(String waitingMessage) {

		List<LayoutBlock> messageFormat = new ArrayList<>();

		messageFormat.add(section(section -> section
			.text(plainText(pt -> pt
				.text(waitingMessage)
				.emoji(true)))));

		return messageFormat;
	}
}
