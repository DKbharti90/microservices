package com.dk.hotel.service.HotelService.service.impl;

import com.dk.hotel.service.HotelService.entity.Hotel;
import com.dk.hotel.service.HotelService.exception.ResourceNotFoundException;
import com.dk.hotel.service.HotelService.repository.HotelRepository;
import com.dk.hotel.service.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findById(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with given id is not available : "+id));
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        hotel.setId(UUID.randomUUID().toString());
        return hotelRepository.save(hotel);
    }
}
