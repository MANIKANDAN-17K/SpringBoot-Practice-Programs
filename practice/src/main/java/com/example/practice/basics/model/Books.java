package com.example.practice.basics.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Books {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private Authors authors;
    public Books(){}
    public Books(String title){
        this.title = title;
    }

    public Authors getAuthor() {
        return authors;
    }
    public void setAuthor(Authors author) {
        this.authors = author;
    }
}
