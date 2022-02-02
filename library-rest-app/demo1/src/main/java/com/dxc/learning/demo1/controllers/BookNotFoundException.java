package com.dxc.learning.demo1.controllers;

public class BookNotFoundException extends RuntimeException {
    BookNotFoundException(Integer id) {
        super("Could not find Book " + id);

    }
}