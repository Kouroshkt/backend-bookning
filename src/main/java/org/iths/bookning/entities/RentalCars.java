package org.iths.bookning.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalCars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserInformation userInformation;
    @OneToOne
    @JoinColumn(name = "car_id",nullable = false)
    private Car car;
    @OneToOne
    @JoinColumn(name = "return_city_id",nullable = false)
    private City city;
    private String startDate;
    private String startTime="10:00";
    private String endDate;
    private String endTime="9:00";
    private String paymentMethod;
    private String rentalDays;

    @Transient
    public long getRentalDays() {
        if (startDate != null && endDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate start = LocalDate.parse(startDate, formatter);
            LocalDate end = LocalDate.parse(endDate, formatter);
            return ChronoUnit.DAYS.between(start, end);
        }
        return 0;
    }

}
