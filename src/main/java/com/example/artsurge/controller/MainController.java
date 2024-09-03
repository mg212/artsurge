package com.example.artsurge.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.servlet.http.HttpSession;

import com.example.artsurge.model.Role;
import com.example.artsurge.service.UserService;

/**
 * Controller for handling main application routes.
 */
@Controller
public class MainController {

    @Autowired
    private UserService userService;

    /**
     * Handles the root URL and redirects based on user role.
     * - Redirects to "/admin" if the user has the "ROLE_SUPER" authority.
     * - Otherwise, redirects to "/buyers".
     *
     * @param session the HTTP session
     * @return redirect URL based on user role
     */
    @GetMapping("/")
    public String root(HttpSession session) {
        System.out.println("IN MainController->root()");

        Collection<? extends GrantedAuthority> userRoles;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userRoles = ((UserDetails) principal).getAuthorities();

            for (GrantedAuthority userRole : userRoles) {
                if (userRole.getAuthority().equals("ROLE_SUPER")) {
                    System.out.println("USER ROLE=" + userRole.getAuthority());
                    return "redirect:/admin";
                }
            }
        }

        System.out.println("USER ROLE Defaults to Regular USER");
        return "redirect:/buyers";
    }

    /**
     * Displays the admin page.
     *
     * @param model the model to be used by the view
     * @return the view name for admin page
     */
    @GetMapping("/admin")
    public String admin(Model model) {
        System.out.println("IN MainController->admin()");
        return "admin";
    }

    /**
     * Displays the login page.
     *
     * @param model the model to be used by the view
     * @return the view name for login page
     */
    @GetMapping("/login")
    public String login(Model model) {
        System.out.println("IN MainController->login()");
        return "login";
    }

    /**
     * Displays the user index page.
     *
     * @return the view name for user index page
     */
    @GetMapping("/user")
    public String userIndex() {
        System.out.println("IN MainController->userIndex()");
        return "user/index";
    }

    /**
     * Handles logout success and returns a confirmation message.
     *
     * @return a confirmation message
     */
    @ResponseBody
    @GetMapping("/logoutSuccess")
    public String logoutResponse() {
        System.out.println("IN MainController->logoutResponse()");
        return "Logged Out!!!!";
    }
}
