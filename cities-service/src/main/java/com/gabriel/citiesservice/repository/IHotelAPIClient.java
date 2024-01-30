package com.gabriel.citiesservice.repository;

import com.gabriel.citiesservice.dto.HotelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotels-service")
public interface IHotelAPIClient {
    @GetMapping("/hotel/{id_city}")
    public List<HotelDTO> findHotelsByCityId(@PathVariable ("id_city") Long id_city);
}
