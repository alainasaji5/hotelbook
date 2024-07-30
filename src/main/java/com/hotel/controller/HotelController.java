package com.hotel.controller;


import com.hotel.entity.Hotel;
import com.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public String listHotels(Model model) {
        model.addAttribute("hotels", hotelService.findAll());
        return "hotel_list";
    }

    @GetMapping("/search")
    public String searchHotels(@RequestParam String name, Model model) {
        model.addAttribute("hotels", hotelService.searchHotels(name));
        return "hotel_list";
    }

    @GetMapping("/{id}")
    public String showHotelDetails(@PathVariable Long id, Model model) {
        Hotel hotel = hotelService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid hotel Id:" + id));
        model.addAttribute("hotel", hotel);
        return "hotel_details";
    }


}
