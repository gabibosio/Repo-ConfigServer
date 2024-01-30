package com.gabriel.hotelsservice.service;

import com.gabriel.hotelsservice.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IHotelService {

    List<Hotel> hotelsList = new ArrayList<>();

    @Override
    public List<Hotel> getListHotelByCityId(Long city_id) {
        List<Hotel> listhotel = new ArrayList<>();
        //carga la bd logica
        this.createHotels();

        //busca si coincide el id
        for(Hotel h: hotelsList){
            if(h.getId_city() == city_id){
                listhotel.add(h);
            }
        }
        return listhotel;
    }

    public void createHotels(){
        hotelsList.add(new Hotel(1L,"Paradise", 5, 1L));
        hotelsList.add(new Hotel(2L, "Sunset View", 4, 2L));
        hotelsList.add(new Hotel(3L, "Ocean Breeze", 3, 3L));
        hotelsList.add(new Hotel(4L, "Mountain Retreat", 4, 1L));
        hotelsList.add(new Hotel(5L, "City Lights Inn", 3, 2L));
        hotelsList.add(new Hotel(6L, "Riverside Lodge", 4, 3L));
        hotelsList.add(new Hotel(7L, "Cozy Cabin Resort", 2, 1L));
        hotelsList.add(new Hotel(8L, "Luxury Haven", 5, 2L));
        hotelsList.add(new Hotel(9L, "Historic Grand Hotel", 4, 3L));
        hotelsList.add(new Hotel(10L, "Tranquil Gardens", 3, 1L));
    }
}
