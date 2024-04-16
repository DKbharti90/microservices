package com.dk.user.service.UserService.controller;

import com.dk.user.service.UserService.domain.User;
import com.dk.user.service.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> getAllStaff(){
        List<User> allUsers= userService.getUsers();
        return ResponseEntity.ok(allUsers);
    }

}
