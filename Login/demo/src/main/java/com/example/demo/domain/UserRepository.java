package com.example.demo.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private Map<Long, User> users = new HashMap<>();
    private static Long sequence = 0L;
    private static UserRepository instance = new UserRepository();

    public UserRepository(){};

    public static UserRepository getInstance() {
        return instance;
    } //생성자

    public User save(User user){
        user.setId(sequence++);
        users.put(user.getId(), user);
        return user;
    } //user를 map에 입력

    public User findId(Long id){
        return users.get(id);
        //id에 해당하는 user를 반환
    }
    public User findbyName(String name){
        return users.values()
                .stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElse(null);
    }
    public List<User> findAll(){
        return new ArrayList<User> (users.values());
    }

    public void remove(Long id) {
        users.remove(id);
    }
}
