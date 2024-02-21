package com.springsecurity.config;

import com.springsecurity.constant.Role;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class RoutingConfig implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority(Role.ROLE_+Role.ADMIN)))
            response.sendRedirect("/api/v1/admin/dashboard");
        else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority(Role.ROLE_+Role.USER)))
            response.sendRedirect("/api/v1/user/dashboard");
        else
            response.sendError(404, "Invalid user role");
    }
}
