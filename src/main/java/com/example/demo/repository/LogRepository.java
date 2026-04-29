package com.example.demo.repository;

import com.example.demo.entity.mongo.LogEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogEntry, String> {
}