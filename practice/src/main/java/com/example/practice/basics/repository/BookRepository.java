package com.example.practice.basics.repository;

import com.example.practice.basics.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Books, Long> {
}
