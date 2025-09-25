package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> findUsers() {
        return userRepository.findAll();
    }
    public String add(User user) {
        userRepository.save(user);
        return "add";
    }
    public String update(User touser, Long id) {
        User find_User = userRepository.findAll()
                .stream()
                .filter(user -> user.getId().equals(id))
                .findAny()
                .orElse(null);
        if(find_User != null){
            find_User.setId(touser.getId());
            find_User.setName(touser.getName());
            return "success";
        }
        return "false";
    }
    public String delete(Long id) {
        User find_user = userRepository.findAll()
                .stream()
                .filter(user -> user.getId().equals(id))
                .findAny()
                .orElse(null);
        if(find_user != null){
            userRepository.remove(find_user.getId());
            return "success";
        }
        return "not valid";
    }
}
