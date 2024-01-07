package com.firstspringbackend.Auth.Application.Services;

import com.firstspringbackend.Auth.Domain.Entities.AuthResponse;
import com.firstspringbackend.Auth.Domain.Entities.LoginRequest;
import com.firstspringbackend.Auth.Domain.Repositories.AuthRepositoryService;
import com.firstspringbackend.Users.Application.Services.UserService;
import com.firstspringbackend.Users.Domain.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements AuthRepositoryService {
    @Autowired
    UserService userService;
    @Autowired
    JwtService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        UserDetails user = userService.getByUsername(loginRequest.getUsername());
        return new AuthResponse(jwtService.getToken(user));
    }

    @Override
    public AuthResponse register(User userRequest) {
        User user = userService.createUser(userRequest);
        return new AuthResponse(jwtService.getToken(user));
    }
}
