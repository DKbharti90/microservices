package com.dk.user.service.UserService.service;

import com.dk.user.service.UserService.domain.User;

import java.util.List;

public interface UserService {


    // Create user;

    User createUser(User user);

    //Get all user

    List<User> getUsers();

    User getUserByID(String id);

}
