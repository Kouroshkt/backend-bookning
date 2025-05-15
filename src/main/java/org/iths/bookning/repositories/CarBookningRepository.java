package org.iths.bookning.repositories;

import org.iths.bookning.entities.CarBookning;
import org.iths.bookning.entities.UserInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBookningRepository extends CrudRepository<CarBookning, Long> {
    Iterable<CarBookning> findByCarId(Long carId);

    Iterable<CarBookning> findByUserInformation(UserInformation user);
}
