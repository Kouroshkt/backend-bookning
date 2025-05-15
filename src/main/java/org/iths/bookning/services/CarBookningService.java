package org.iths.bookning.services;

import org.iths.bookning.entities.CarBookning;
import org.iths.bookning.entities.UserInformation;
import org.iths.bookning.repositories.CarBookningRepository;
import org.iths.bookning.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Service
public class CarBookningService {
    private final CarBookningRepository carBookningRepository;
    private final UserService us;

    public CarBookningService(CarBookningRepository carBookningRepository, UserService us) {
        this.carBookningRepository = carBookningRepository;
        this.us = us;
    }

    public boolean checkDate(Long carId, String startDate, String endDate) {
        Iterable<CarBookning> listCarBookning = carBookningRepository.findByCarId(carId);
        LocalDate newStart;
        LocalDate newEnd;
        try {
        newStart = LocalDate.parse(startDate);
        newEnd = LocalDate.parse(endDate);
        }catch (DateTimeParseException e){
            throw new IllegalArgumentException("Invalid date format");
        }
        for (CarBookning carBookning : listCarBookning) {
            LocalDate start = LocalDate.parse(carBookning.getStartDate());
            LocalDate end = LocalDate.parse(carBookning.getEndDate());
            if (!(newStart.isAfter(end) || newEnd.isBefore(start) || newEnd.equals(start) || newStart.equals(end)))
                return false;
        }
        return true;
    }

    public void addCarBookning(CarBookning carBookning) {
        carBookningRepository.save(carBookning);
    }

    public Iterable<CarBookning> getCarByUser(Long userId) {
        UserInformation user= us.getUserById(userId);
        if (user != null) {
            return carBookningRepository.findByUserInformation(user);
        }
        return null;
    }
}
