package com.example.practice.basics.service;

import com.example.practice.basics.DTO.LoginRequest;
import com.example.practice.basics.model.User;
import com.example.practice.basics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    public User register(User user){
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }
    public String login(LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(()-> new RuntimeException("User not found"));
        boolean isMatch = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
        if(!isMatch){
            throw new RuntimeException("Invalid password");
        }
        return jwtService.generateToken(user.getEmail());
    }
}
