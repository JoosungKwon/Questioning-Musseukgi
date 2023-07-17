package com.kwonjs.questioningmusseukgi.slack.utils;

import static lombok.AccessLevel.*;

import org.springframework.util.MultiValueMap;

import com.google.gson.Gson;
import com.slack.api.app_backend.interactive_components.payload.BlockActionPayload;
import com.slack.api.app_backend.slash_commands.payload.SlashCommandPayload;
import com.slack.api.util.json.GsonFactory;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class SlackMessageMapper {

	private static final Gson gson = GsonFactory.createSnakeCase();

	public static SlashCommandPayload covertSlashCommandPayload(MultiValueMap<String, Object> multiValueMap) {

		SlashCommandPayload slashCommandPayload = new SlashCommandPayload();

		slashCommandPayload.setCommand(String.valueOf(multiValueMap.getFirst("command")));
		slashCommandPayload.setUserId(String.valueOf(multiValueMap.getFirst("user_id")));
		slashCommandPayload.setUserName(String.valueOf(multiValueMap.getFirst("user_name")));
		slashCommandPayload.setChannelId(String.valueOf(multiValueMap.getFirst("channel_id")));
		slashCommandPayload.setChannelName(String.valueOf(multiValueMap.getFirst("channel_name")));
		slashCommandPayload.setResponseUrl(String.valueOf(multiValueMap.getFirst("response_url")));
		slashCommandPayload.setTeamDomain(String.valueOf(multiValueMap.getFirst("team_domain")));
		slashCommandPayload.setText(String.valueOf(multiValueMap.getFirst("text")));

		return slashCommandPayload;
	}

	public static BlockActionPayload covertBlockActionPayload(String payload) {
		return gson.fromJson(payload, BlockActionPayload.class);
	}
}
