package com.example.demo.controller;


import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<User> getUsers() {
        return userService.findUsers();
    }
    @RequestMapping(method = RequestMethod.POST, path="/add")
    public String addUser(@RequestBody User user) {
        return userService.add(user);
    }
    @RequestMapping(method = RequestMethod.PUT, path="/update/{id}")
    public String Update(@RequestBody User touser, @PathVariable Long id){
        return userService.update(touser, id);
    }
    @RequestMapping(method = RequestMethod.DELETE, path="/delete/{id}")
    public String Delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
