package com.cts.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TaskManagerApp {
	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApp.class, args);
	}
}
