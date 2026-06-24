package com.example.practice.basics.controller;

import com.example.practice.basics.model.Authors;
import com.example.practice.basics.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @GetMapping("/author/{id}")
    public Authors getAuthor(
            @PathVariable Long id
    ){
        return authorService.getAuthor(id);
    }
    @PostMapping("/author")
    public Authors saveAuthors(@RequestBody Authors authors){
        for(var book : authors.getBooks()){
            book.setAuthor(authors);
        }
        return authorService.saveAuthors(authors);
    }
}
