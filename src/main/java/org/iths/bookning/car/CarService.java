package org.iths.bookning.car;

import org.iths.bookning.carCategory.CategoryRepository;
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
