package com.firstspringbackend.Auth.Domain.Repositories;

import com.firstspringbackend.Auth.Domain.Entities.AuthResponse;
import com.firstspringbackend.Auth.Domain.Entities.LoginRequest;
import com.firstspringbackend.Users.Domain.Entities.User;

public interface AuthRepositoryService {
    AuthResponse login(LoginRequest loginRequest);
    AuthResponse register(User userRequest);
}
