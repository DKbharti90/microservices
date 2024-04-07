package com.dk.user.service.UserService.external.service;

import com.dk.user.service.UserService.domain.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService{

    @GetMapping("/rating/user/{userId}")
    List<Rating> findRattingByUserId(@PathVariable String userId);


}
