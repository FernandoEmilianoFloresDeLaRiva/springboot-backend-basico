package com.firstspringbackend.Users.Infraestructure.Controllers;

import com.firstspringbackend.Auth.Application.Services.AuthService;
import com.firstspringbackend.Users.Application.Services.UserService;
import com.firstspringbackend.Users.Domain.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail (@PathVariable("email") String email){
        User user = userService.getByEmail(email);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUserByUsername (@PathVariable("username") String username){
        User user = userService.getByUsername(username);
        return ResponseEntity.status(200).body(user);
    }
    @PutMapping("/{email}")
    public ResponseEntity<User> updateUser(@PathVariable("email") String email, @RequestBody User requestUser){
        User updatedUser = userService.updateUser(email, requestUser);
        return ResponseEntity.status(200).body(updatedUser);
    }
    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable("email") String email){
        if (userService.deleteUser(email)) return ResponseEntity.status(200).body("User with email "+email+" deleted succesfully!");
        return ResponseEntity.status(404).body("User with email "+email+" not found!");
    }
}
