package com.cts.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cts.rest.service.TaskManagerService;
import com.cts.rest.service.TaskManagerServiceImpl;

@Configuration
public class TaskManagerConfig {

	@Bean
	public TaskManagerService taskManagerService() {
		return new TaskManagerServiceImpl();
	}
}
