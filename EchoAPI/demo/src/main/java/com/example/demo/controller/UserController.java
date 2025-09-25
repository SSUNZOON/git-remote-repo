package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository = UserRepository.getInstance();

    @RequestMapping(method = RequestMethod.GET, path= "/list")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    @RequestMapping(method = RequestMethod.POST, path="/add")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
