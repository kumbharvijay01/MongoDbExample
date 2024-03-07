package com.org.bhfl.mongodbdemo.MongoDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}
}
