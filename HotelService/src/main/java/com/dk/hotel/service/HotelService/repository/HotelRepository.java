package com.dk.hotel.service.HotelService.repository;

import com.dk.hotel.service.HotelService.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}
