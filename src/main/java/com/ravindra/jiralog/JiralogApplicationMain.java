package com.ravindra.jiralog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.ravindra.*")
@SpringBootApplication
public class JiralogApplicationMain {

	public static void main(String[] args) {
		SpringApplication.run(JiralogApplicationMain.class, args);
	}

}
