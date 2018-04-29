package com.example.blog.controllers;

import com.example.blog.models.User;
import com.example.blog.models.UserRole;
import com.example.blog.repositories.Roles;
import com.example.blog.repositories.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private Users users;
    private PasswordEncoder passwordEncoder;
    private Roles roles;

    public UserController(Users users, PasswordEncoder passwordEncoder, Roles roles) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.roles = roles;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "/users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        roles.save(UserRole.blogger(user));
        return "redirect:/login";
    }
}
