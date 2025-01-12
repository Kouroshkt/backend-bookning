package org.iths.bookning.repositories;

import org.iths.bookning.entities.UserInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserInformation, Long> {
    UserInformation findByEmail(String email);

    UserInformation findByUsername(String username);
}
