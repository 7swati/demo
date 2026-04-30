package com.example.demo.service;

import com.example.demo.bean.UserDipRequest;
import com.example.demo.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface DipCollectionService {

    public void saveUserDipRequest(UserDipRequest request);
}
