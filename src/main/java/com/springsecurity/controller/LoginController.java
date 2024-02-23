package com.springsecurity.controller;

import com.springsecurity.constant.Role;
import com.springsecurity.dto.ApiResponse;
import com.springsecurity.dto.AuthenticationResponse;
import com.springsecurity.dto.UserDataDto;
import com.springsecurity.model.UserData;
import com.springsecurity.service.api.AuthenticationService;
import com.springsecurity.service.api.JwtService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ModelAndView addUser( UserData user) {
        authenticationService.register(user);
        return new ModelAndView("login");
    }

    @PostMapping("/login/login-user")
    public ModelAndView login(UserDataDto user, HttpServletResponse response) {
        AuthenticationResponse authenticationResponse = authenticationService.login(user);
        UserData userData = authenticationService.getUser(user.getUserName());
        ModelAndView mnv = new ModelAndView("home");
        mnv.addObject("user", userData);
        mnv.addObject("token", authenticationResponse.getToken());
        mnv.addObject("role", userData.getRole());
        return mnv;
    }

    @GetMapping("/login/login-page")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    @GetMapping("/register-page")
    public ModelAndView registerPage() {
        return new ModelAndView("signup");
    }


    @PostMapping("/admin/dashboard")
    public ModelAndView adminDashboard(ApiResponse response) {
        UserDataDto userDataDto = new UserDataDto(response.getUserName(), response.getPassword());
        if (jwtService.isValid(response.getToken(), userDataDto)) {
            ModelAndView modelAndView;
            if(response.getRole().equals(Role.ROLE_+Role.ADMIN)) {
                modelAndView = new ModelAndView("admin");
                modelAndView.addObject("token", response.getToken());
                modelAndView.addObject("user", userDataDto);
                modelAndView.addObject("role",response.getRole());
            }
            else {
                modelAndView = new ModelAndView("error");
                modelAndView.addObject("message","Not authorized");
            }
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("message", "Invalid Token");
            return modelAndView;
        }
    }

    @PostMapping("/user/dashboard")
    public ModelAndView userDashboard(ApiResponse response) {
        UserDataDto userDataDto = new UserDataDto(response.getUserName(), response.getPassword());
        if (jwtService.isValid(response.getToken(), userDataDto)) {
                ModelAndView modelAndView = new ModelAndView("user");
                modelAndView.addObject("token", response.getToken());
                modelAndView.addObject("user", userDataDto);
            modelAndView.addObject("role",response.getRole());
                return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("message", "Invalid Token");
            return modelAndView;
        }
    }
}
