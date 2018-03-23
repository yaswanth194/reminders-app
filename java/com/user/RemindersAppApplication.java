package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.user.authentication.UserController;

@SpringBootApplication
public class RemindersAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemindersAppApplication.class, args);
	}
}
