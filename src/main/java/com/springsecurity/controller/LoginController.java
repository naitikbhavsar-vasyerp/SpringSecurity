package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @GetMapping("/admin/dashboard")
    public String adminDashboard(){
        return "Welcome to admin dashboard";
    }

    @GetMapping("/user/dashboard")
    public String userDashboard(){
        return "Welcome to user dashboard";
    }
}
