package com.dxc.learning.demo1.service;

import com.dxc.learning.demo1.model.Book;

import java.util.List;

public interface BookService {

    // GET /books all books
    // GET /books/{id} book with the id
    // POST /books create a new book
    // PUT /books/{id} update the book with the id
    // DELETE /books/{id} delete the book with the id

    public Book getBookId(int id);

    public Book getBookname(String title);

    public Book getBookemail(String isbn);

    public Book createBook(Book book);

    public Book updateBook(int id);

    public void deleteBook(int id);

    public List<Book> getAllBook();
}