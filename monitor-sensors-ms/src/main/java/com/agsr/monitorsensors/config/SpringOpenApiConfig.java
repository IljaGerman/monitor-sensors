package com.agsr.monitorsensors.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;


@Configuration
@SecurityScheme(
	type = SecuritySchemeType.HTTP,
	name = "basicAuth",
	scheme = "basic")
public class SpringOpenApiConfig {

	@Value("${app.description}")
	String appDescription;
	@Value("${app.version}")
	String appVersion;

	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI().info(new Info().title("Application API")
				.version(appVersion)
				.description(appDescription)
				.license(new License().name("Apache 2.0")
					.url("http://springdoc.org")))
			.servers(Collections.singletonList(new Server().url("http://localhost:8080")));
	}

}