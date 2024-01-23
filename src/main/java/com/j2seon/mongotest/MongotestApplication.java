package com.j2seon.mongotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongotestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongotestApplication.class, args);
	}

}
