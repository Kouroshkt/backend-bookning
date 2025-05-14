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
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;
    private String startDate;
    private String endDate;

    public CarBookning(Car car, String startDate, String endDate) {
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
