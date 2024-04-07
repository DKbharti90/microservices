package com.dk.rating.service.RatingService.service;

import com.dk.rating.service.RatingService.entity.Rating;

import java.util.List;

public interface RatingService {

    List<Rating> findAll();

    Rating findById(String id);

    Rating saveRating(Rating rating);

    List<Rating> findRattingByUserId(String id);

    List<Rating> findRattingByHotelId(String id);

}
