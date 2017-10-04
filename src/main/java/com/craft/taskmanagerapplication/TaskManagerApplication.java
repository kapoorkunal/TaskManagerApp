package com.craft.taskmanagerapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.craft")
@EnableMongoRepositories("com.craft.repository")
public class TaskManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}
}
