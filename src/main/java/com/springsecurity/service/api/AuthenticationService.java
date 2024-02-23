package com.springsecurity.service.api;


import com.springsecurity.dto.AuthenticationResponse;
import com.springsecurity.dto.UserDataDto;
import com.springsecurity.model.UserData;

public interface AuthenticationService {
    void register(UserData userData);
    AuthenticationResponse login(UserDataDto userData);

    UserData getUser(String userName);
}
