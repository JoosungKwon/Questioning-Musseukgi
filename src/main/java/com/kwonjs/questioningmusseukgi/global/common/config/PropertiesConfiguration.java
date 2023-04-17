package com.kwonjs.questioningmusseukgi.global.common.config;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {ChatGptConfig.class, SlackConfig.class})
public class PropertiesConfiguration {
}