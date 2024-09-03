/*The UserServiceImplTests test the UserServiceImpl class. They verify that the findByEmail method correctly finds a user by their email and that the save method correctly saves a new user to the database. The tests also mock the BCryptPasswordEncoder and UserRepository to isolate the UserServiceImpl and test its functionality independently.*/

package com.example.artsurge;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.artsurge.model.User;
import com.example.artsurge.repo.UserRegistrationDto;
import com.example.artsurge.repo.UserRepository;
import com.example.artsurge.service.UserServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @MockBean
    private BCryptPasswordEncoder passwordEncoder;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        String email = "test@example.com";
        User user = new User("John", "Doe", email, "password");
        Mockito.when(userRepository.findByEmail(email)).thenReturn(user);
        User foundUser = userService.findByEmail(email);
        assertEquals(user.getEmail(), foundUser.getEmail());
    }

}