package org.iths.bookning.carCategory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CarCategory, Long> {

    Iterable<CarCategory> findByCityId(Long cityId);
}
