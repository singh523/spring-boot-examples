package com.example.tdd.service;

import com.example.tdd.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public List<User> findAllUsers() {
        return List.of(new User(1, "Test", "test@mail.com"));
    }

    public User findByUserId(int id) {
        return getUsers().stream().filter(user -> user.id() == id).findFirst().orElse(null);
    }

    private static List<User> getUsers() {
        return List.of(new User(1, "Test", "test@mail.com"),
                new User(2, "Test2", "test2@mail.com"),
                new User(3, "Test3", "test3@mail.com"));
    }
}
