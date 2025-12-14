package com.basics.ReviseSpringBasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class ReviseSpringBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviseSpringBasicsApplication.class, args);
	}

}
