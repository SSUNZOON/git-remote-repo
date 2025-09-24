package com.example.demo.domain;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private static Map<Long, User> users = new HashMap<>();
    private static long sequence = 0L;

    public User save(User user){
        user.setId(++sequence);
        users.put(user.getId(), user); //여기서 put() 자료구조 자체 메서드?
        return user;
    }
    public User findId(Long id){
        return users.get(id);
    }
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
    public Optional<User> findbyName(String name){
        return users.values().stream()
                .filter(user -> user.getName().equals(name)).findAny();
    }
}
