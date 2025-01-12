package org.iths.bookning.repositories;

import org.iths.bookning.entities.CarCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CarCategory, Long> {

    Iterable<CarCategory> findByCityId(Long cityId);
}
