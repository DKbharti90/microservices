package com.dk.user.service.UserService.service.impl;

import com.dk.user.service.UserService.domain.Hotel;
import com.dk.user.service.UserService.domain.Rating;
import com.dk.user.service.UserService.exception.ResourceNotFoundException;
import com.dk.user.service.UserService.external.service.HotelService;
import com.dk.user.service.UserService.external.service.RatingService;
import com.dk.user.service.UserService.repository.UserRepository;
import com.dk.user.service.UserService.service.UserService;
import com.dk.user.service.UserService.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    @Override
    public User createUser(User user) {
        String randomUserid= UUID.randomUUID().toString();
        user.setUserId(randomUserid);
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {

        return userRepository.findAll();
    }

    @Override
    public User getUserByID(String id) {

        User user=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user with given id is not present in server :"+id));

       /**
        *  Using the RestTemplate but now we Rea not using the rest template
        *  ArrayList<Rating> getForObject=restTemplate.getForObject("http://localhost:8083/rating/user/"+user.getUserId(), ArrayList.class);
        user.setRatings(getForObject);
        */

       /**
        * Using the FeignClient
        * */

        List<Rating> ratings=ratingService.findRattingByUserId(user.getUserId());
        List<Hotel> hotels=new ArrayList<>();
        Map<String, Hotel> hotelCache = new HashMap<>();
        ratings.forEach(rating -> {
            String hotelId = rating.getHotelId();
            Hotel hotel = hotelCache.computeIfAbsent(hotelId, hotelService::getHotel);
            if (hotel != null) {
                hotels.add(hotel);
            }
        });
        user.setRatings(ratings);
        user.setHotels(hotels);

        return user;
    }
}
