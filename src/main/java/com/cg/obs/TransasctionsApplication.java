package com.cg.obs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class TransasctionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransasctionsApplication.class, args);
	}
	@Bean
	public RestTemplate createTemplate() {
		return new RestTemplate();
	}
}
