package org.iths.bookning.controller;

import org.iths.bookning.entities.Car;
import org.iths.bookning.entities.CarBookning;
import org.iths.bookning.entities.UserInformation;
import org.iths.bookning.services.CarBookningService;
import org.iths.bookning.services.CarService;
import org.iths.bookning.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carbookning")
@CrossOrigin(origins = "http://localhost:3000")
public class CarBookningController {
    private final CarBookningService carBookningService;
    private final CarService carService;
    private final UserService use;

    public CarBookningController(CarBookningService carBookningService, CarService carService, UserService use) {
        this.carBookningService = carBookningService;
        this.carService = carService;
        this.use = use;
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
    public ResponseEntity<String> addCarBookning(@RequestParam Long userId,@RequestParam Long carId, @RequestParam String startDate, @RequestParam String endDate) {
        Car car= carService.getCarById(carId);
        UserInformation user= use.getUserById(userId);
        carBookningService.addCarBookning(new CarBookning(car, user,startDate, endDate));
        return ResponseEntity.ok("CarBookning added successfully");
    }
    @GetMapping("/getcarbyuser")
    public Iterable<CarBookning> getCarByUser(@RequestParam Long userId) {
        return carBookningService.getCarByUser(userId);
    }

}
