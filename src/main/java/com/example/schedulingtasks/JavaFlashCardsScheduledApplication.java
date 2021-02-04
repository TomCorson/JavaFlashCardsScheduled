package com.example.schedulingtasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaFlashCardsScheduledApplication {

	public static void main(String[] args) {

		SpringApplication.run(JavaFlashCardsScheduledApplication.class);
	}

}
