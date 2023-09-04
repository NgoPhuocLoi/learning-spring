package com.example.easy_school_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.easy_school_app.repositories")
@EntityScan("com.example.easy_school_app.models")
public class EasySchoolAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasySchoolAppApplication.class, args);
	}

}
