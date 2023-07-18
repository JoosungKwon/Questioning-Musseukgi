package com.kwonjs.questioningmusseukgi.support.slack.command;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kwonjs.questioningmusseukgi.support.slack.service.SlackService;
import com.kwonjs.questioningmusseukgi.support.slack.utils.SlackMessageMapper;
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

	@PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void subscribe(@RequestParam MultiValueMap<String, Object> payload) {

		log.info("Slack Command Action String Payload: {}", payload);

		SlashCommandPayload slashCommandPayload =
			SlackMessageMapper.covertSlashCommandPayload(payload);

		String command = slashCommandPayload.getCommand();

		log.info("Slack Command Action Payload: {}", slashCommandPayload);

		final String responseUrl = slashCommandPayload.getResponseUrl();

		slackService.sendMessage(responseUrl, "명령어를 처리하고 있습니다.", true);

		if (command.equals("/subscribe")) {
			registerUser(slashCommandPayload);
			// case "/change" -> registerUser(slashCommandPayload);
		}

		slackService.sendMessage(responseUrl, "정상적으로 구독이 완료되었습니다.", true);
	}

	private void registerUser(SlashCommandPayload payload) {

		String userName = payload.getUserName();
		String channelId = payload.getChannelId();
		String text = payload.getText();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

		LocalTime time = LocalTime.parse(text, formatter);

		User user = User.builder()
			.nickname(userName)
			.musseukgiName("머쓱이")
			.channel(channelId)
			.slackWebhookUrl("https://hooks.slack.com/")
			.generatorType("random")
			.senderName("slack")
			.iconEmoji("musseukgi")
			.notificationTime(time)
			.build();

		userRepository.save(user);
	}
}
