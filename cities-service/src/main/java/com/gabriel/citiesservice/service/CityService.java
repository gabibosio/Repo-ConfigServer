package com.gabriel.citiesservice.service;

import com.gabriel.citiesservice.dto.CityDTO;
import com.gabriel.citiesservice.model.City;
import com.gabriel.citiesservice.repository.IHotelAPIClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements ICityService{

    @Autowired
    private IHotelAPIClient hotelAPIClient;

    List<City> cities = new ArrayList<>();


    public City findCity(String name, String country) {
        this.crateCities();
        for(City  c: cities){
            if(c.getName().equals(name)){
                if(c.getCountry().equals(country)){
                    return c;
                }
            }
        }
        return null;
    }

    @Override
    //name el mismo del servicio
    //fallback es el metodo al que envio en caso de que algo no funcione
    @CircuitBreaker(name = "hotels-service" , fallbackMethod = "fallbackGetCitiesHotel")
    @Retry(name = "hotels-service")
    public CityDTO getCityHotels(String name, String country) {
        //buscamos la ciudad original
        City city = this.findCity(name,country);
        //creamos el DTO de la ciudad + la lista de hoteles
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId_city(city.getId_city());
        cityDTO.setContinent(city.getContinent());
        cityDTO.setProvince(city.getProvince());
        cityDTO.setName(city.getName());
        cityDTO.setCountry(city.getCountry());
        //buscamos la lista de hoteles en la API y asignamos
        cityDTO.setListHotels(hotelAPIClient.findHotelsByCityId(city.getId_city()));
        //aca llamo a la excepcion
        //createException();
        return cityDTO;
    }

    public CityDTO fallbackGetCitiesHotel(Throwable throwable){
        return new CityDTO(9999999L, "Fail", "Fail", "Fail", "Fail",null);
    }

    public void createException(){
        throw new IllegalArgumentException("Resilience and Circuit Breaker");
    }

    public void crateCities(){
        cities.add(new City(1L, "Buenos Aires", "South America", "Argentina", "Buenos Aires"));
        cities.add(new City(2L, "Oberá", "South America", "Argentina", "Misiones"));
        cities.add(new City(3L, "Mexico City", "North America", "Mexico", "Mexico City"));
        cities.add(new City(4L, "Guadalajara", "North America", "Mexico", "Jalisco"));
        cities.add(new City(5L, "Bogotá", "South America", "Colombia", "Cundinamarca"));
        cities.add(new City(6L, "Medellín", "South America", "Colombia", "Antioquia"));
        cities.add(new City(7L, "Santiago", "South America", "Chile", "Santiago Metropolitan"));
        cities.add(new City(8L, "Valparaíso", "South America", "Chile", "Valparaíso"));
        cities.add(new City(9L, "Asunción", "South America", "Paraguay", "Asunción"));
        cities.add(new City(10L, "Montevideo", "South America", "Uruguay", "Montevideo"));
        cities.add(new City(11L, "Madrid", "Europe", "Spain", "Community of Madrid"));
        cities.add(new City(12L, "Barcelona", "Europe", "Spain", "Catalonia"));
        cities.add(new City(13L, "Seville", "Europe", "Spain", "Andalucia"));
        cities.add(new City(14L, "Monterrey", "North America", "Mexico", "Nuevo León"));
        cities.add(new City(15L, "Valencia", "Europe", "Spain", "Valencian Community"));
    }


}
