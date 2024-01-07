package com.firstspringbackend.Users.Domain.Repositories;

import com.firstspringbackend.Users.Domain.Entities.User;

import java.util.List;

public interface UserServiceRepository {
    List<User> getUsers();
    User createUser(User user);
    User getByEmail(String email);
    User getByUsername(String username);
    User updateUser(String email, User user);
    Boolean deleteUser(String email);
}
