package com.springsecurity.service.api;

import com.springsecurity.dto.UserDataDto;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public interface JwtService {

    String generateToken(UserDataDto userData);

    <T> T extractClaim(String token, Function<Claims, T> resolver);

    String getUserName(String token);

    boolean isValid(String token, UserDataDto userDataDto);

}
