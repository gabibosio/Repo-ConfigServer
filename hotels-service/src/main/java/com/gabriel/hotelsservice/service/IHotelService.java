package com.gabriel.hotelsservice.service;

import com.gabriel.hotelsservice.model.Hotel;

import java.util.List;

public interface IHotelService {
    public List<Hotel> getListHotelByCityId(Long city_id);
}
