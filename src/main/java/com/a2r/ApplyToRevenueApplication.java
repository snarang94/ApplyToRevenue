package com.a2r;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApplyToRevenueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplyToRevenueApplication.class, args);
	}

}
