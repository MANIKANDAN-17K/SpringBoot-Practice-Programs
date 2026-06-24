package com.example.practice.basics.service;

import com.example.practice.basics.model.Authors;
import com.example.practice.basics.model.Books;
import com.example.practice.basics.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    public Authors saveAuthors( Authors authors){
        return authorRepository.save(authors);
    }
    public Authors getAuthor(Long id){
        return authorRepository.findById(id).orElseThrow(()-> new RuntimeException("Author not found"));
    }
}
