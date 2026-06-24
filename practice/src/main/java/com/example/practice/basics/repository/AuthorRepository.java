package com.example.practice.basics.repository;

import com.example.practice.basics.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Authors,Long> {

}
