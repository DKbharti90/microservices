package com.dk.rating.service.RatingService.service.impl;

import com.dk.rating.service.RatingService.entity.Rating;
import com.dk.rating.service.RatingService.exception.ResourceNotFoundException;
import com.dk.rating.service.RatingService.repository.RatingRepository;
import com.dk.rating.service.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating findById(String id) {
        return ratingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Rating not found with given id : "+id));
    }

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> findRattingByUserId(String id) {
        return ratingRepository.findByUserId(id);
    }

    @Override
    public List<Rating> findRattingByHotelId(String id) {
        return ratingRepository.findByHotelId(id);
    }
}
