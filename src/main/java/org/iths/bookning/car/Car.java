package org.iths.bookning.car;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iths.bookning.carCategory.CarCategory;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String color;
    private int seats;
    @ManyToOne
    @JoinColumn(name = "car_category_id")
    private CarCategory carCategory;
}
