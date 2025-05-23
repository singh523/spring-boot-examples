package com.example.tdd.controller;

import com.example.tdd.model.User;
import com.example.tdd.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class UserController {


    private UserService userService;

    @GetMapping("/findAllUsers")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("findById/{id}")
    public User findById(@PathVariable int id){
        return userService.findByUserId(id);
    }

}
