package com.projectImage.Image_Gallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectImage.Image_Gallery.services.UserServices;
import com.projectImage.Image_Gallery.models.LoginRequest;
import com.projectImage.Image_Gallery.models.User;

import org.springframework.http.HttpStatus;



@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    private UserServices userService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        
        User user = userService.authenticateUser(loginRequest);

 
        if (user != null) {

            return ResponseEntity.ok().body("Authentication successful");
        } else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }
}

