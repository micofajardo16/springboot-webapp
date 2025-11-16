package com.example.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// Using Controller
// @Controller
// public class HomeController {

//     @RequestMapping("/")
//      @ResponseBody
//     public String greet() {
//         System.out.println("greet is called.");
//         return "Welcome to Home!";
//     }
// }

// Using RestController
@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet() {
        return "Welcome to Home!";
    }

    @RequestMapping("/about")
    public String about() {
        return "About!";
    }
}