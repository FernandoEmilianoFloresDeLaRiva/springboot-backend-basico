package com.firstspringbackend.Auth.Infraestructure.Controllers;

import com.firstspringbackend.Auth.Application.Services.AuthService;
import com.firstspringbackend.Auth.Domain.Entities.AuthResponse;
import com.firstspringbackend.Auth.Domain.Entities.LoginRequest;
import com.firstspringbackend.Users.Domain.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody User user){
        AuthResponse token = authService.register(user);
        return ResponseEntity.status(201).body(token);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest user){
        AuthResponse token = authService.login(user);
        return ResponseEntity.status(200).body(token);
    }
}
