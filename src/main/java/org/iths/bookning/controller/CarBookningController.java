package org.iths.bookning.controller;

import org.iths.bookning.services.CarBookningService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carbookning")
@CrossOrigin(origins = "http://localhost:3000")
public class CarBookningController {
    private final CarBookningService carBookningService;

    public CarBookningController(CarBookningService carBookningService) {
        this.carBookningService = carBookningService;
    }


    @GetMapping("/carcheck")
    public ResponseEntity<Boolean> carcheck(
            @RequestParam Long carId,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        boolean result = carBookningService.checkDate(carId,startDate,endDate);
        return ResponseEntity.ok(result);
    }

}
