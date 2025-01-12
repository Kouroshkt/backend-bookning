package org.iths.bookning.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private int seats;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "car_category_id", nullable = false) // Koppling till CarCategory
    private CarCategory carCategory;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false) // Koppling till City
    private City city;
}
