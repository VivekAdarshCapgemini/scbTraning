package com.springsecuritygoogleoAuth.googleoAuth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoogleOAuthController {

    @GetMapping("/oAuthJwt")
    public String googleAuth() {
        return "Welcome to Google OAuth";
    }

}
