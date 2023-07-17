package com.kwonjs.questioningmusseukgi.common.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.kwonjs.questioningmusseukgi")
public class FeignConfig {
}
