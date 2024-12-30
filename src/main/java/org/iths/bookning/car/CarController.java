package org.iths.bookning.car;

import org.springframework.http.ResponseEntity;
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
    public Iterable<Car> getCar(@RequestParam Long cityId, @RequestParam Long carCategoryId) {
        return carService.getCar(cityId, carCategoryId);
    }
    @GetMapping("/getallcar")
    public Iterable<Car> getAllCar() {
        return carService.allCar();
    }
}
