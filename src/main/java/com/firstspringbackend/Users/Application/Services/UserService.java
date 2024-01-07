package com.firstspringbackend.Users.Application.Services;

import com.firstspringbackend.Users.Domain.Entities.User;
import com.firstspringbackend.Users.Domain.Repositories.UserRepository;
import com.firstspringbackend.Users.Domain.Repositories.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceRepository {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return  userRepository.save(user);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User updateUser(String email, User user) {
        return null;
    }

    @Override
    public Boolean deleteUser(String email) {
        return null;
    }
}
