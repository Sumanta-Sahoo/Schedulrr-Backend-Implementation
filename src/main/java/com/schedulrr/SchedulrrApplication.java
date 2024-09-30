package com.schedulrr;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class SchedulrrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulrrApplication.class, args);
	}

	@Bean
	public static ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
