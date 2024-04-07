package com.dk.user.service.UserService.controller;

import com.dk.user.service.UserService.domain.User;
import com.dk.user.service.UserService.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User returnuser= userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnuser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        User user= userService.getUserByID(userId);
        return ResponseEntity.ok(user);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUsers= userService.getUsers();
        return ResponseEntity.ok(allUsers);
    }

}
