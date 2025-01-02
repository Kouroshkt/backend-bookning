package org.iths.bookning.services;

import org.iths.bookning.entities.Car;
import org.iths.bookning.repositories.CarRepository;
import org.iths.bookning.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository, CategoryRepository categoryRepository) {
        this.carRepository = carRepository;
    }

    public Iterable<Car> allCar() {
        return carRepository.findAll();
    }

    public Iterable<Car> getCar(Long cityId, Long carCategoryId) {
        return carRepository.findByCity_IdAndCarCategory_Id(cityId, carCategoryId);
    }
}
