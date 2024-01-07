package com.firstspringbackend.Users.Application.Services;

import com.firstspringbackend.Users.Domain.Entities.Role;
import com.firstspringbackend.Users.Domain.Entities.User;
import com.firstspringbackend.Users.Domain.Repositories.UserRepository;
import com.firstspringbackend.Users.Domain.Repositories.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
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
    public User updateUser(String email, User userRequest) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) return null;
        user.setRole(userRequest.getRole());
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Boolean deleteUser(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        if(user != null){
            userRepository.deleteByEmail(email);
            return true;
        }
        return false;
    }
}
