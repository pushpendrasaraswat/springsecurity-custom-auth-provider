package com.ps.springsecuritycustomauthprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    String sayWelcome() {
        return "Welcome to spring security";
    }
}
