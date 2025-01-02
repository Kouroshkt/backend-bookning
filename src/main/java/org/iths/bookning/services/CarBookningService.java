package org.iths.bookning.services;

import org.iths.bookning.repositories.CarBookningRepository;
import org.springframework.stereotype.Service;

@Service
public class CarBookningService {
    private final CarBookningRepository carBookningRepository;

    public CarBookningService(CarBookningRepository carBookningRepository) {
        this.carBookningRepository = carBookningRepository;
    }
}
