package com.dxc.learning.demo1.controllers;

public class AuthorNotFoundException extends RuntimeException{
    AuthorNotFoundException(Integer id) {
        super("Could not find Author " + id);

}
}