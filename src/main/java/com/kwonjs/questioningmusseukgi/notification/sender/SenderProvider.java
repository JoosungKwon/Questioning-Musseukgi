// package com.kwonjs.questioningmusseukgi.notification.sender;
//
// import java.util.Collections;
// import java.util.Map;
// import java.util.function.Function;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;
//
// import javax.annotation.PostConstruct;
//
// import org.springframework.stereotype.Component;
//
// import com.kwonjs.questioningmusseukgi.notification.sender.slack.Client;
// import com.kwonjs.questioningmusseukgi.notification.sender.slack.SlackSender;
//
// import lombok.Getter;
// import lombok.RequiredArgsConstructor;
//
// @Getter
// @RequiredArgsConstructor
// public enum SenderProvider {
//
// 	SLACK("slack") {
//
// 		private Client client;
//
// 		@Override
// 		public Sender getSender() {
// 			return new SlackSender(client);
// 		}
//
// 		@Override
// 		public void setClient(Client client) {
// 			this.client = client;
// 		}
//
// 	};
//
// 	private final String name;
//
// 	private static final Map<String, SenderProvider> PROVIDERS =
// 		Collections.unmodifiableMap(Stream.of(values())
// 			.collect(Collectors.toMap(SenderProvider::getName, Function.identity())));
//
// 	public static SenderProvider getSenderProviderByName(String providerName) {
// 		if (!PROVIDERS.containsKey(providerName.toLowerCase())) {
// 			throw new IllegalArgumentException("지원하지 않는 알림입니다.");
// 		}
// 		return PROVIDERS.get(providerName);
// 	}
//
// 	public abstract Sender getSender();
// 	abstract void setClient(Client client);
//
//
// 	@Component
// 	@RequiredArgsConstructor
// 	public static class ClientInjector {
//
// 		private Client client;
//
// 		@PostConstruct
// 		public void postConstruct() {
// 			for (SenderProvider provider : values())
// 				provider.setClient(client);
// 		}
// 	}
//
// }
