package com.example.demo;

import com.example.demo.domain.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public UserService memberService() {return new UserService(userRepository());}
    @Bean
    public UserRepository userRepository() {return new UserRepository();}
}
