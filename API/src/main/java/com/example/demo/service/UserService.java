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
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Long join(User user){
        duplicateUser(user); //유저 중복유무 확인
        userRepository.save(user); //없으면 저장
        return user.getId();
    }
    private void duplicateUser(User user){
        userRepository.findbyName(user.getName())
                .ifPresent(m->
                {throw new IllegalStateException("이미존재하는 회원입니다");});
    }
    public List<User> findUsers() {
        return userRepository.findAll();
    }
    public User findOne(Long userId){
        return userRepository.findId(userId);
    }
}
