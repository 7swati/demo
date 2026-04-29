package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class ,
		MongoAutoConfiguration.class,
		MongoDataAutoConfiguration.class
})
// ✅ Tell JPA where to look
@EnableJpaRepositories(basePackages = "com.example.demo.repository.jpa")

// ✅ Tell Mongo where to look
@EnableMongoRepositories(basePackages = "com.example.demo.repository.mongo")

// ✅ Tell JPA where entities are
@EntityScan(basePackages = "com.example.demo.entity")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
