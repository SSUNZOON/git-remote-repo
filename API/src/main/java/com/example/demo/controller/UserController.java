package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/User/{id}")
    public User getUser(@PathVariable("id")Long id) {
        return userService.findOne(id);
    }
    @GetMapping("/User/all")
    public List<User> getAllUser(){
        return userService.findUsers();
    }

    @PutMapping("/User/new/{name}")
    public void putMember(@PathVariable("name") String name){
        User user = new User();
        user.setName(name);
        userService.join(user);
    }
}
