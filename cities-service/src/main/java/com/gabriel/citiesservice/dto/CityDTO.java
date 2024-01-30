package com.gabriel.citiesservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {

    private Long id_city;
    private String name;
    private String continent;
    private String country;
    private String province;
    private List<HotelDTO> listHotels;
}
