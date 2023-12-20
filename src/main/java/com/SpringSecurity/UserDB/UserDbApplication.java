package com.SpringSecurity.UserDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDbApplication.class, args);
		System.out.println("Server has been started");
	}

}
