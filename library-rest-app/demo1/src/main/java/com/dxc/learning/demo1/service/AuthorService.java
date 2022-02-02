package com.dxc.learning.demo1.service;

import com.dxc.learning.demo1.model.Author;

import java.util.List;

public interface AuthorService {

    // GET /authors all authors
    // GET /authors/{id} author with the id
    // POST /authors create a new author
    // PUT /authors/{id} update the author with the id
    // DELETE /authors/{id} delete the author with the id

    public Author getAuthorId(int id);

    public Author getAuthorname(String name);

    public Author getAuthoremail(String email);

    public Author createAuthor(Author author);

    public Author updateAuthor(int id);

    public void deleteAuthor(int id);

    public List<Author> getAllAuthor();
}
