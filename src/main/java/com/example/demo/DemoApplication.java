package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication  // ✅ No excludes!
@EnableJpaRepositories(basePackages = "com.example.demo.repository.jpa")
@EnableMongoRepositories(basePackages = "com.example.demo.repository.mongo")
@EntityScan(basePackages = "com.example.demo.entity")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}