package com.schedulrr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SchedulrrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulrrApplication.class, args);
	}

}
