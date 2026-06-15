package com.example.practice.basics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDeveloper {
    @GetMapping("/")
    public String hello(){
        return "Hello, Developer!";
    }
}
