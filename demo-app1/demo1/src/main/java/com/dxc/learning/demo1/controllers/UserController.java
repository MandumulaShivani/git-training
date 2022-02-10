package com.dxc.learning.demo1.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.dxc.learning.demo1.model.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private static List<User> users = new ArrayList();

    @GetMapping({ "", "/" })
    public List<User> getAll() {
        return users;
    }

    @PostMapping({ "", "/" })
    public User create(@RequestBody User user) {
        user.setCreationDate(LocalDate.now());
        users.add(user);
        return user;
    }
}
