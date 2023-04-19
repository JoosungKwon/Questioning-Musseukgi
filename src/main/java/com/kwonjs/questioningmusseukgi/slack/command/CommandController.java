package com.kwonjs.questioningmusseukgi.slack.command;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kwonjs.questioningmusseukgi.slack.service.SlackService;
import com.kwonjs.questioningmusseukgi.user.model.User;
import com.kwonjs.questioningmusseukgi.user.repository.UserRepository;
import com.slack.api.app_backend.slash_commands.payload.SlashCommandPayload;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/command")
@RequiredArgsConstructor
public class CommandController {

	private final SlackService slackService;
	private final UserRepository userRepository;

	@PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void subscribe(@RequestParam MultiValueMap<String, Object> payload) {
		log.info("Slack Command Action Payload: {}", payload);


		// String command = slashCommandPayload.getCommand();
		//
		// final String responseUrl = slashCommandPayload.getResponseUrl();
		//
		//
		// slackService.sendWaitMessage(responseUrl, "명령어를 처리하고 있습니다.");
		//
		// switch (command) {
		// 	case "/subscribe" -> registerUser(slashCommandPayload);
		// }

		// slackService.sendWaitMessage(responseUrl, "정상적으로 구독이 완료되었습니다.");
	}

	private void registerUser(SlashCommandPayload payload) {

		String userName = payload.getUserName();
		String channelId = payload.getChannelId();
		String text = payload.getText();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

		LocalTime time = LocalTime.parse(text, formatter);

		User user = User.builder()
			.nickname(userName)
			.musseukgiName(null)
			.channel(channelId)
			.generatorType("random")
			.senderName("slack")
			.notificationTime(time)
			.build();

		userRepository.save(user);
	}
}
