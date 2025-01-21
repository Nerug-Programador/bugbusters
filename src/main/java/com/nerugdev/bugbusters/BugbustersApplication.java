package com.nerugdev.bugbusters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.nerugdev.bugbusters.usuario")
public class BugbustersApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugbustersApplication.class, args);
	}

}
