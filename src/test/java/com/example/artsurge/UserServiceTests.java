/*testFindByEmail_ExistingEmail: Tests if the findByEmail method in the UserService finds an existing user by their email. It creates a test user, mocks the repository to return that user, and then checks if the found user matches the original one.

testFindByEmail_NonExistingEmail: Tests if the findByEmail method in the UserService returns null for a non-existing email. It mocks the repository to return null for a non-existing email and checks if the found user is null.

testSaveUser: Tests if the save method in the UserService saves a new user correctly, including encoding the password. It creates a test user registration DTO, mocks the repository to return a saved user, and checks if the saved user has the correct email and if the password is encoded.*/


package com.example.artsurge;

import com.example.artsurge.model.User;
import com.example.artsurge.repo.UserRegistrationDto;
import com.example.artsurge.repo.UserRepository;
import com.example.artsurge.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testFindByEmail_ExistingEmail() {
        // Mock user data
        User user = new User("John", "Doe", "john.doe@example.com", "password");

        // Mock repository behavior
        Mockito.when(userRepository.findByEmail(user.getEmail())).thenReturn(user);

        // Find user by email
        User foundUser = userService.findByEmail(user.getEmail());

        // Assert that the retrieved user is correct
        assertNotNull(foundUser);
        assertEquals(user, foundUser);
    }

    @Test
    public void testFindByEmail_NonExistingEmail() {
        // Mock repository behavior
        Mockito.when(userRepository.findByEmail("non-existent@email.com")).thenReturn(null);

        // Find user by non-existing email
        User foundUser = userService.findByEmail("non-existent@email.com");

        // Assert that no user is found
        assertNull(foundUser);
    }

    @Test
    public void testSaveUser() {
        // Mock user registration data
        UserRegistrationDto registrationDto = new UserRegistrationDto();
        registrationDto.setFirstName("John");
        registrationDto.setLastName("Doe");
        registrationDto.setEmail("john.doe@example.com");
        registrationDto.setPassword("password");
        registrationDto.setConfirmPassword("password");

        // Mock repository behavior (use Mockito to mock BCryptPasswordEncoder)
        User savedUser = new User();
        savedUser.setEmail(registrationDto.getEmail());
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(savedUser);

        // Save user
        User user = userService.save(registrationDto);

        // Assert that the user is saved with encoded password
        assertNotNull(user);
        assertNotEquals(registrationDto.getPassword(), user.getPassword());
    }
}