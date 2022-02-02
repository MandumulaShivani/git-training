package com.dxc.learning.demo1.service;

import java.util.List;
import com.dxc.learning.demo1.model.Author;
import com.dxc.learning.demo1.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(int id) {
        Author author = getAuthorId(id).orElseThrow();
        authorRepository.delete(author);
    }

    @Override
    public List<Author> getAllAuthor() {
        // TODO Auto-generated method stub
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorId(int id) {
        return authorRepository.findById(id).orElseThrow();
    }

    @Override
    public Author getAuthoremail(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Author getAuthorname(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Author updateAuthor(int id) {
        return authorRepository.getById(id);
    }

}
