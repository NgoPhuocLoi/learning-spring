package com.example.comsuming_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.comsuming_rest.proxy")
public class ComsumingRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComsumingRestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		return restTemplateBuilder.basicAuthentication("admin@gmail.com", "8f3DXH2z").build();

	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder().filter(ExchangeFilterFunctions.basicAuthentication("admin@gmail.com", "8f3DXH2z"))
				.build();
	}
}
