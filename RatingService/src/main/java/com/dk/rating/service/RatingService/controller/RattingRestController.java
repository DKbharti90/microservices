package com.dk.rating.service.RatingService.controller;

import com.dk.rating.service.RatingService.entity.Rating;
import com.dk.rating.service.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RattingRestController {

    @Autowired
    private RatingService ratingService;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> findRatingById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> findAllRating(){
        return ResponseEntity.ok(ratingService.findAll());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> findRatingByUserId(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.findRattingByUserId(userId));
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> findRatingByHotelId(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.findRattingByHotelId(hotelId));
    }
}
