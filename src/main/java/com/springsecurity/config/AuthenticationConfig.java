package com.springsecurity.config;

import com.springsecurity.constant.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class AuthenticationConfig {

    @Autowired
    private UserCredentials userCredentials;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                        authorizationManagerRequestMatcherRegistry
                                .requestMatchers("/api/v1/admin/dashboard").hasRole(Role.ADMIN)
                                .requestMatchers("/api/v1/user/dashboard").hasAnyRole(Role.ADMIN, Role.USER)
                                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(httpSecurityFormLoginConfigurer ->
                        httpSecurityFormLoginConfigurer.successHandler(new RoutingConfig())
                );
        return httpSecurity.build();
    }

    @Bean
    static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    InMemoryUserDetailsManager addUsersToMemory() {

        List<UserDetails> users = new ArrayList<>();
        for (int i = 0; i < userCredentials.userName.size(); i++) {
            UserDetails user = User.builder()
                    .username(userCredentials.getUserName().get(i))
                    .password(passwordEncoder().encode(userCredentials.getPassword().get(i)))
                    .roles(userCredentials.getRole().get(i))
                    .build();
            users.add(user);
        }

        return new InMemoryUserDetailsManager(users);
    }


}
