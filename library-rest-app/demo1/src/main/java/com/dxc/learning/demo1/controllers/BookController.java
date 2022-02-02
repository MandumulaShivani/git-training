package com.dxc.learning.demo1.controllers;

import java.time.LocalDate;
import java.util.List;
import com.dxc.learning.demo1.model.Book;
import com.dxc.learning.demo1.repository.BookRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookRepository repository;

    BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    List<Book> all() {
        return repository.findAll();
    }

    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }

    @GetMapping("/books/{id}")
    Book one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @PutMapping("/books/{id}")
    Book replaceEmployee(@RequestBody Book newBook, @PathVariable Integer id) {

        return repository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setIsbn(newBook.getIsbn());
                    book.setPublicationDate(LocalDate.now());
                    return repository.save(book);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return repository.save(newBook);
                });
    }

    @DeleteMapping("/books/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}