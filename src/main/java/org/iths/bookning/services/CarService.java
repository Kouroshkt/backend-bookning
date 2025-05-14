package org.iths.bookning.services;

import org.iths.bookning.entities.Car;
import org.iths.bookning.repositories.CarRepository;
import org.iths.bookning.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final CarBookningService carBookningService;

    public CarService(CarRepository carRepository, CategoryRepository categoryRepository, CarBookningService carBookningService) {
        this.carRepository = carRepository;
        this.carBookningService = carBookningService;
    }

    public Iterable<Car> allCar() {
        return carRepository.findAll();
    }

    public Iterable<Car> getCar(Long cityId, Long carCategoryId) {
        return carRepository.findByCity_IdAndCarCategory_Id(cityId, carCategoryId);
    }

    public Iterable<Car> getCarByDate(Long cityId, Long carCategoryId, String startDate, String endDate) {
        List<Car> newListCar = new ArrayList<>();
        Iterable<Car> listCar=carRepository.findByCity_IdAndCarCategory_Id(cityId,carCategoryId);
        for (Car car:listCar){
            Long carId=car.getId();
            if(carBookningService.checkDate(carId,startDate,endDate)){
                newListCar.add(car);
            }
        }
        return newListCar;
    }

    public Car getCarById(Long carId) {
        return carRepository.findById(carId).orElse(null);
    }
}
