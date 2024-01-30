package com.gabriel.hotelsservice.controller;

import com.gabriel.hotelsservice.model.Hotel;
import com.gabriel.hotelsservice.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @GetMapping("/{city_id}")
    public List<Hotel> getListHotel(@PathVariable Long city_id){
        return hotelService.getListHotelByCityId(city_id);
    }
}
