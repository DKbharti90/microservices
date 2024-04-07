package com.dk.rating.service.RatingService.repository;

import com.dk.rating.service.RatingService.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {

    //Custom finder method
    List<Rating> findByHotelId(String id);
    List<Rating> findByUserId(String id);

}
