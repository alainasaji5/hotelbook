package com.hotel.service;


import com.hotel.entity.Hotel;
import com.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> searchHotels(String name) {

        return hotelRepository.findByNameContaining(name);
    }

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    /*public List<Hotel> findById() {
        return hotelRepository.findbyId(id);


    }*/
}
