package com.springsecurity.service.impl;


import com.springsecurity.constant.Role;
import com.springsecurity.dto.AuthenticationResponse;
import com.springsecurity.dto.UserDataDto;
import com.springsecurity.model.UserData;
import com.springsecurity.repository.UserRepository;
import com.springsecurity.service.api.AuthenticationService;
import com.springsecurity.service.api.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;




    @Override
    public void register(UserData userData) {
        UserData userData1 = new UserData();
        userData1.setUserName(userData.getUsername());
        userData1.setRole(Role.ROLE_ + userData.getRole());
        userData1.setPassword(passwordEncoder.encode(userData.getPassword()));
        userRepository.save(userData1);
    }

    @Override
    public AuthenticationResponse login(UserDataDto userData) {
        ModelMapper modelMapper = new ModelMapper();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userData.getUserName(), userData.getPassword()
                )
        );

        UserDataDto userDataDto = modelMapper.map(userRepository.findById(userData.getUserName()).orElseThrow(() -> new RuntimeException("User not found")), UserDataDto.class);
        String token = jwtService.generateToken(userDataDto);
        return new AuthenticationResponse(token);
    }

    @Override
    public UserData getUser(String userName) {
        return userRepository.findById(userName).orElseThrow(RuntimeException::new);
    }
}
