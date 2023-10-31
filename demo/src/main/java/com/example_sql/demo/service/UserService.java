package com.example_sql.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example_sql.demo.model.User;
import com.example_sql.demo.model.UserRole;
import com.example_sql.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void add(User user) {
        userRepository.add(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void remove(int id) {
        userRepository.remove(id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public List<User> getAll(String name) {
        return userRepository.getAll(name);
    }

    public List<UserRole> getAllWithRole() {
        return userRepository.getAllWithRole();
    }
}
