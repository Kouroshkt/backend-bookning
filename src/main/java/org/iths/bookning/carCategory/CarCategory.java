package org.iths.bookning.carCategory;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iths.bookning.car.Car;
import org.iths.bookning.city.City;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private String description;
    private String categoryImage;
    @OneToMany(mappedBy = "carCategory", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Car> cars;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
