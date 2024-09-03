package org.maksimgoncharov.artsurge.service;



import org.springframework.security.core.userdetails.UserDetailsService;


import org.maksimgoncharov.artsurge.model.User;
import org.maksimgoncharov.artsurge.repo.UserRegistrationDto;


public interface UserService extends UserDetailsService {
    User findByEmail(String email);
    User save(UserRegistrationDto registration);
}


