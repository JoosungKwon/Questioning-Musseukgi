// package com.kwonjs.questioningmusseukgi.question.generater.service;
//
// import java.util.Collections;
// import java.util.Map;
// import java.util.function.Function;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;
//
// import com.kwonjs.questioningmusseukgi.notification.sender.Sender;
// import com.kwonjs.questioningmusseukgi.notification.sender.SenderProvider;
//
// import lombok.Getter;
// import lombok.RequiredArgsConstructor;
//
// @Getter
// @RequiredArgsConstructor
// public enum GenerateType {
// 	RANDOM("random"){
//
// 		generatorName = "random";
//
// 		@Override
// 		public SenderProvider getSenderProvider() {
// 			return SenderProvider.getSenderProviderByName("random");
// 		}
// 	}, // 랜덤
// 	CUSTOM("custom"); // 사용자 설정
//
// 	private final String name;
// 	private String generatorName;
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
// }
