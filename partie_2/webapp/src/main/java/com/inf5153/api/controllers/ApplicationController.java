package com.inf5153.api.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    
    @GetMapping("/login")
    public String redirectToLoginPage() {
        return "views/login";
    }

    @GetMapping("/")
    public String redirectAfterLogin() {
        return "redirect:/documents";
    }
}
