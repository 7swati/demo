package com.example.demo.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "logs")
@Getter
@Setter
public class LogEntry {

    @Id
    private String id;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }



}