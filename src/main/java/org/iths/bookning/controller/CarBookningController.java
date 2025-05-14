package org.iths.bookning.controller;

import org.iths.bookning.entities.Car;
import org.iths.bookning.entities.CarBookning;
import org.iths.bookning.services.CarBookningService;
import org.iths.bookning.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carbookning")
@CrossOrigin(origins = "http://localhost:3000")
public class CarBookningController {
    private final CarBookningService carBookningService;
    private final CarService carService;

    public CarBookningController(CarBookningService carBookningService, CarService carService) {
        this.carBookningService = carBookningService;
        this.carService = carService;
    }


    @GetMapping("/carcheck")
    public ResponseEntity<Boolean> carcheck(
            @RequestParam Long carId,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        boolean result = carBookningService.checkDate(carId,startDate,endDate);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/addcarbookning")
    public ResponseEntity<String> addCarBookning(@RequestParam Long carId, @RequestParam String startDate, @RequestParam String endDate) {
        System.out.println(carId+ "  "+startDate+"  "+endDate);
        Car car= carService.getCarById(carId);
        carBookningService.addCarBookning(new CarBookning(car, startDate, endDate));
        return ResponseEntity.ok("CarBookning added successfully");

    }

}
