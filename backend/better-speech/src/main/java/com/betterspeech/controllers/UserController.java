package com.betterspeech.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betterspeech.dto.CreateUserRequest;
import com.betterspeech.dto.UserResponse;
import com.betterspeech.model.User;
import com.betterspeech.services.UserServices;



@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserServices userServices;

    public UserController(UserServices userServices){
        this.userServices = userServices;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        User created = userServices.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        User user = userServices.getUserById(id);
        return ResponseEntity.ok(new UserResponse(user));
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userServices.getAllUsers().stream()
                .map(UserResponse::new)
                .toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userServices.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
