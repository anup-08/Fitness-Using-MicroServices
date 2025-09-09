package com.userService.controller;

import com.example.dtos.UserRequest;
import com.example.dtos.UserResponse;
import com.userService.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserResponse> addUser(@Valid @RequestBody UserRequest request){
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<UserResponse> getUserDetails(@PathVariable String email){
        return ResponseEntity.ok(userService.getUserDetails(email));
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping("/isValid/{userId}")
    public ResponseEntity<Boolean> isUserValid(@PathVariable Long userId){
        return ResponseEntity.ok(userService.isUserValid(userId));
    }
}
