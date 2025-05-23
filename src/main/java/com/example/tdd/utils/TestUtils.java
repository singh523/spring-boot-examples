package com.example.tdd.utils;

import com.example.tdd.model.Product;
import com.example.tdd.model.User;

import java.util.List;

public final class TestUtils {

    public static List<Product> mockProducts() {
        return List.of(new Product(1, "Product1", "Product1 description", 100.00));
    }

    public static List<User> getUsers() {
        return List.of(new User(1, "Test", "test@mail.com"),
                new User(2, "Test2", "test2@mail.com"),
                new User(3, "Test3", "test3@mail.com"));
    }
}
