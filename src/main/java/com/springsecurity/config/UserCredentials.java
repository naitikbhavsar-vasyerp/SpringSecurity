package com.springsecurity.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
@Component
@ConfigurationProperties(prefix = "user")
public class UserCredentials {
    List<String> userName;
    List<String> password;
    List<String> role;
}
