package org.iths.bookning.car;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    Iterable<Car> findByCity_IdAndCarCategory_Id(Long cityId, Long carCategoryId);

}
