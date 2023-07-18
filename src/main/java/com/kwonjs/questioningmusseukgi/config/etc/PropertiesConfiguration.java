package com.kwonjs.questioningmusseukgi.config.etc;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {ChatGptConfig.class, SlackConfig.class})
public class PropertiesConfiguration {
}