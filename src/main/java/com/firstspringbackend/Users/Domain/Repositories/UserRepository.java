package com.firstspringbackend.Users.Domain.Repositories;

import com.firstspringbackend.Users.Domain.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    void deleteByEmail(String email);
}
