package com.example.demo.domain;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private static Map<Long, User> users = new HashMap<>();
    private static long sequence = 0L;
    private static UserRepository instance = new UserRepository();

    public static UserRepository getInstance() {
        return instance;
    }

    static {
        // 기존에 있는 users 변수를 활용하여 사용자 추가
        User user1 = new User("John Doe");
        user1.setId(++sequence);
        users.put(user1.getId(), user1);

        User user2 = new User("Jane Smith");
        user2.setId(++sequence);
        users.put(user2.getId(), user2);
    }


    public User save(User user) {
        user.setId(++sequence);
        users.put(user.getId(), user); //여기서 put() 자료구조 자체 메서드?
        return user;
    }

    public User findId(Long id) {
        return users.get(id);
    }
    public User findbyName(String name) {
        for (User user : users.values()) {
            if (user.getName().equals(name))
                return user;
        }
        return null;
    }
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
}

