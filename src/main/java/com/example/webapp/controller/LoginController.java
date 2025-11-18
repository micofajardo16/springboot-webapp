package com.example.webapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Added a second controller, to demonstrate how does Spring know which controller to pick
// Technically just make it unique since Spring sees all of it
@RestController
public class LoginController {
    
    @RequestMapping("/login")
    public String login() {
        return "Login";
    }
}
