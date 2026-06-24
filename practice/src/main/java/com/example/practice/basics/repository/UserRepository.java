package com.example.practice.basics.repository;

import com.example.practice.basics.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository
extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
