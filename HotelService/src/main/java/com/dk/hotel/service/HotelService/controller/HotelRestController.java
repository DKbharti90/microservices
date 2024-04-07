package com.dk.hotel.service.HotelService.controller;

import com.dk.hotel.service.HotelService.entity.Hotel;
import com.dk.hotel.service.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelRestController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return  ResponseEntity.status(HttpStatus.CREATED).body(hotelService.saveHotel(hotel));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> findAllHotel(){
        return ResponseEntity.ok(hotelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> findAllHotelById(@PathVariable String id){
        return  ResponseEntity.status(HttpStatus.OK).body(hotelService.findById(id));
    }

}
