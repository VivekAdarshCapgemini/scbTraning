package com.dsscbweek3.springsecurity.springsecurityDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityCheckerController {


    @GetMapping("/admin")
    public String home() {
        return ("Week 3 Spring Security Demo - Admin Page #1");
    }


}
