package org.iths.bookning.services;

import org.iths.bookning.entities.City;
import org.iths.bookning.repositories.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    public Iterable<City> allCity(){
        return cityRepository.findAll();
    }
}
