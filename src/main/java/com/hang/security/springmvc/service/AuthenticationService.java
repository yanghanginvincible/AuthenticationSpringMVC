package com.hang.security.springmvc.service;

import com.hang.security.springmvc.model.AuthenticationRequest;
import com.hang.security.springmvc.model.UserDto;

public interface AuthenticationService {
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
