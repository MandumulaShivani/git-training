package com.dxc.learning.demo1.controllers;

import java.time.LocalDate;
import java.util.List;
import com.dxc.learning.demo1.model.Author;
import com.dxc.learning.demo1.repository.AuthorRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    private final AuthorRepository repository;

    AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/authors")
    List<Author> all() {
        return repository.findAll();
    }

    @PostMapping("/authors")
    Author newAuthor(@RequestBody Author newAuthor) {
        return repository.save(newAuthor);
    }

    @GetMapping("/authors/{id}")
    Author one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }

    @PutMapping("/authors/{id}")
    Author replaceEmployee(@RequestBody Author newAuthor, @PathVariable Integer id) {

        return repository.findById(id)
                .map(author -> {
                    author.setName(newAuthor.getName());
                    author.setEmail(newAuthor.getEmail());
                    author.setCreationDate(LocalDate.now());
                    return repository.save(author);
                })
                .orElseGet(() -> {
                    newAuthor.setId(id);
                    return repository.save(newAuthor);
                });
    }

    @DeleteMapping("/authors/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}