package com.study.projects.clientsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ClientSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientSyncApplication.class, args);
		System.out.print(new BCryptPasswordEncoder().encode("123"));
	}

}
