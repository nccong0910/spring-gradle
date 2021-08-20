package com.example.springgradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableCaching
public class SpringGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGradleApplication.class, args);
	}

}
