package com.dxc.learning.demo1.service;

import java.util.List;
import com.dxc.learning.demo1.model.Book;
import com.dxc.learning.demo1.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        // TODO Auto-generated method stub
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(int id) {
        // TODO Auto-generated method stub
        Book book = getBookId(id).orElseThrow();
        bookRepository.delete(book);
    }

    @Override
    public List<Book> getAllBook() {
        // TODO Auto-generated method stub
        return bookRepository.findAll();
    }

    @Override
    public Book getBookId(int id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public Book getBookemail(String isbn) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Book getBookname(String title) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Book updateBook(int id) {
        return bookRepository.getById(id);
    }

}