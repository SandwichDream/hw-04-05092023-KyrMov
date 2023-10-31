package com.example_sql.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example_sql.demo.model.User;
import com.example_sql.demo.model.UserRole;
import com.example_sql.demo.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getUsers() {
        return "I am user";
    }

    @PostMapping("add")
    public void add(@RequestBody User user) {
        userService.add(user);
    }

    @PostMapping("update")
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    @PostMapping("remove")
    public void remove(@RequestBody int id) {
        userService.remove(id);
    }

    @GetMapping("all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("all")
    public List<User> getAll(@RequestBody String name) {
        return userService.getAll(name);
    }

    @GetMapping("role")
    public List<UserRole> getUserRole() {
        return userService.getAllWithRole();
    }
}
