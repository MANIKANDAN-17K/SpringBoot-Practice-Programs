package com.example.practice.basics.controller;

import com.example.practice.basics.DTO.LoginRequest;
import com.example.practice.basics.model.User;
import com.example.practice.basics.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return authService.register(user);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        String token = authService.login(request);
        return ResponseEntity.ok(token);
    }
}
