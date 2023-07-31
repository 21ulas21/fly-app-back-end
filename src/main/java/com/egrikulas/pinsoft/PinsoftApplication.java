package com.egrikulas.pinsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PinsoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinsoftApplication.class, args);
	}

}
