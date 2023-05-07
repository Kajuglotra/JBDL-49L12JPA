package com.example.demo.service;

import com.example.demo.authordb.Author;
import com.example.demo.authordb.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    public Author addAuthor(Author author) {
        authorRepository.save(author);
        return author;
    }
}
