package org.iths.bookning.controller;

import org.iths.bookning.entities.Car;
import org.iths.bookning.services.CarService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "http://localhost:3000")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/getall")
    public Iterable<Car> allCar() {
        return carService.allCar();
    }

    @GetMapping("/getcar")
    public Iterable<Car> getCar(
            @RequestParam Long cityId,
            @RequestParam Long carCategoryId
    ) {
        return carService.getCar(cityId, carCategoryId);
    }
    @GetMapping("/getallcar")
    public Iterable<Car> getAllCar() {
        return carService.allCar();
    }

    @GetMapping("/getcarbyDate")
    public Iterable<Car> getCarByDate(
            @RequestParam Long cityId,
            @RequestParam Long carCategoryId,
            @RequestParam String startDate,
            @RequestParam String endDate
    ){
        return carService.getCarByDate(cityId,carCategoryId,startDate,endDate);
    }
}
