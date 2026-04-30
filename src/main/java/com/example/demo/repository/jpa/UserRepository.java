package com.example.demo.repository.jpa;

import com.example.demo.entity.jpa.UserDipDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDipDetails, Integer> {
}
