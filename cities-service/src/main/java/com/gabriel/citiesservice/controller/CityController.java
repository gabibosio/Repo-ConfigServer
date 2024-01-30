package com.gabriel.citiesservice.controller;

import com.gabriel.citiesservice.dto.CityDTO;
import com.gabriel.citiesservice.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private ICityService cityService;

    @GetMapping("/hotels")
    public CityDTO getCityHotels(@RequestParam String name , @RequestParam String country){
        return cityService.getCityHotels(name,country);
    }
}
