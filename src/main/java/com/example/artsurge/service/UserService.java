package com.example.artsurge.service;



import org.springframework.security.core.userdetails.UserDetailsService;


import com.example.artsurge.model.User;
import com.example.artsurge.repo.UserRegistrationDto;


public interface UserService extends UserDetailsService {
    User findByEmail(String email);
    User save(UserRegistrationDto registration);
}


