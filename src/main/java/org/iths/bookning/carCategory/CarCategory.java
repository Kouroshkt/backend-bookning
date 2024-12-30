package org.iths.bookning.carCategory;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iths.bookning.city.City;


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

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}