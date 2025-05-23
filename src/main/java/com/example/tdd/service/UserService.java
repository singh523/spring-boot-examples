package com.example.tdd.service;

import com.example.tdd.model.User;
import com.example.tdd.utils.TestUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public List<User> findAllUsers() {
        return List.of(new User(1, "Test", "test@mail.com"));
    }

    public User findByUserId(int id) {
        return TestUtils.getUsers().stream().filter(user -> user.id() == id).findFirst().orElse(null);
    }
}
