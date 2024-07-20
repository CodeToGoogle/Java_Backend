package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Author;
import com.example.librarymanagement.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public Author createOrGet(Author author){
        Author authorFromDb=this.authorRepository.findByEmail(author.getEmail());
        if(authorFromDb !=null){
            return authorFromDb;
        }
        return this.authorRepository.save(author);
    }

    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }
}
