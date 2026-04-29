package com.example.demo.repository.mongo;

import com.example.demo.entity.mongo.LogEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogEntry, String> {
}