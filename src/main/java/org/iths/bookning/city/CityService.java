package org.iths.bookning.city;

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
