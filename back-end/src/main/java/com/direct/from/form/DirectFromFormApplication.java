package com.direct.from.form;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.direct.from.form.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class DirectFromFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(DirectFromFormApplication.class, args);
	}
}
