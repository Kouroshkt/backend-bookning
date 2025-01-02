package org.iths.bookning.controller;

import org.iths.bookning.entities.City;
import org.iths.bookning.services.CityService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
@CrossOrigin(origins = "http://localhost:3000")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping("/getall")
    public Iterable<City> allCity() {
        return cityService.allCity();
    }
}
