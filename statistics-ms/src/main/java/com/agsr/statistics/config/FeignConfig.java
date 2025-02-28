package com.agsr.statistics.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Configuration
public class FeignConfig {

	@Value("${sensors.service.username}")
	private String username;

	@Value("${sensors.service.password}")
	private String password;

	@Bean
	public RequestInterceptor basicAuthRequestInterceptor() {
		return template -> {
			String auth = username + ":" + password;
			byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
			String authHeader = "Basic " + new String(encodedAuth);

			template.header("Authorization", authHeader);
		};
	}

}
