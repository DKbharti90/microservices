package com.dk.user.service.UserService.controller;

import com.dk.user.service.UserService.domain.User;
import com.dk.user.service.UserService.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

    private static final Logger log = LoggerFactory.getLogger(UserResource.class);
    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User returnuser= userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnuser);
    }

    @GetMapping("/{userId}")
    //@CircuitBreaker(name = "rattingHotelBreaker", fallbackMethod = "rattingHotelBreakerFallback")
   // @Retry(name="rattingHotelServiceRetry", fallbackMethod = "rattingHotelBreakerFallback")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "rattingHotelBreakerFallback")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        User user= userService.getUserByID(userId);
        return ResponseEntity.ok(user);
    }

    int retryCount=0;
    public ResponseEntity<User> rattingHotelBreakerFallback(String userId, Exception exception){
       // log.info("Some of the service is down",exception);
        log.info("Retry Count", retryCount);
        retryCount++;
        var user=User.builder().email("dummy@gmail.com").name("Dummy").userId("123455").build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUsers= userService.getUsers();
        return ResponseEntity.ok(allUsers);
    }

}
