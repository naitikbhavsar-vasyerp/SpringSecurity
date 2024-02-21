package com.springsecurity.controller;

import com.springsecurity.model.UserData;
import com.springsecurity.service.UserJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private UserJpaService userJpaService;

    @GetMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("home");
    }

    @GetMapping("/signup-page")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @PostMapping("/signup")
    public String addUser(UserData user){
        userJpaService.addUser(user);
        return "redirect:/login";
    }
    @GetMapping("/admin/dashboard")
    public ModelAndView adminDashboard(){
        return new ModelAndView("admin");
    }

    @GetMapping("/user/dashboard")
    public ModelAndView userDashboard(){
        return new ModelAndView("user");
    }
}
