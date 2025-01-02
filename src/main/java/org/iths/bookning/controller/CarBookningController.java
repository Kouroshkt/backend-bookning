package org.iths.bookning.controller;

import org.iths.bookning.services.CarBookningService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/carbookning")
public class CarBookningController {
    private final CarBookningService carBookningService;

    public CarBookningController(CarBookningService carBookningService) {
        this.carBookningService = carBookningService;
    }
}
