package com.dk.hotel.service.HotelService.service;

import com.dk.hotel.service.HotelService.entity.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> findAll();

    Hotel findById(String id);

    Hotel saveHotel(Hotel hotel);

}
