package org.iths.bookning.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CarBookning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInformation userInformation;
    private String startDate;
    private String endDate;

    public CarBookning(Car car, UserInformation userInformation, String startDate, String endDate) {
        this.car = car;
        this.userInformation = userInformation;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
