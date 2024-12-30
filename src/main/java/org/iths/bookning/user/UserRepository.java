package org.iths.bookning.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserInformation, Long> {
    UserInformation findByEmail(String email);

    UserInformation findByUsername(String username);
}
