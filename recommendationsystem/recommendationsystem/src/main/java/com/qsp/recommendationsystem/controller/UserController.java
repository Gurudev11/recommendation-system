package com.qsp.recommendationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.recommendationsystem.model.User;
import com.qsp.recommendationsystem.service.UserService;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registrationForm(Model model) {
          return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.register(user); 
        return "redirect:/login"; 
    }
    @GetMapping("/login")
    public String loginForm() {
        return "user-login"; 
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username, @RequestParam String password, Model model) {
        
        if ("user".equals(username) && "password".equals(password)) {
           
            return "login-success"; 
        } else {
            
            return "user-login"; 
        }
    }


    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
