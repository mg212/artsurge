package com.example.artsurge.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.artsurge.model.User;
import com.example.artsurge.repo.UserRegistrationDto;
import com.example.artsurge.service.UserService;

/**
 * Controller for handling user registration.
 */
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    /**
     * Provides a new UserRegistrationDto for registration form binding.
     *
     * @return a new UserRegistrationDto object
     */
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        System.out.println("IN UserRegController->userRegistrationDto()");
        return new UserRegistrationDto();
    }

    /**
     * Displays the registration form.
     *
     * @param model the model to be used by the view
     * @return the view name for registration form
     */
    @GetMapping
    public String showRegistrationForm(Model model) {
        System.out.println("IN UserRegController->showRegistrationForm()");
        return "registration";
    }

    /**
     * Handles form submission for user registration.
     *
     * @param userDto the user registration data from the form
     * @param result the binding result to capture validation errors
     * @return redirect to registration page with success message or show form again in case of errors
     */
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result) {
        System.out.println("IN POST MAPPING UserRegController->registerUserAccount()");

        // Check if a user with the provided email already exists
        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        System.out.println("ZZZZZZZZZZZZZZZ result: " + result.toString());

        // If there are validation errors, return to the registration form
        if (result.hasErrors()) {
            System.out.println("result: " + result.toString());
            return "registration";
        }

        // Save the new user account
        userService.save(userDto);
        return "redirect:/registration?success";
    }
}
