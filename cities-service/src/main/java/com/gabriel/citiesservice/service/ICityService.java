package com.gabriel.citiesservice.service;

import com.gabriel.citiesservice.dto.CityDTO;


public interface ICityService {

    public CityDTO getCityHotels(String name,String country);
}
