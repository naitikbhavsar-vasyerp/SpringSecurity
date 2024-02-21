package com.springsecurity.service;

import com.springsecurity.constant.Role;
import com.springsecurity.model.UserData;
import com.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserJpaServiceImpl implements UserJpaService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(UserData user) {
        UserData userData = new UserData();
        userData.setUserName(user.getUsername());
        userData.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userData.setRole(Role.ROLE_+user.getRole());
        userRepository.save(userData);
    }
}
