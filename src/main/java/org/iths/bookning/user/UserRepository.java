package org.iths.bookning.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserInform, Long> {
    UserInform findByEmail(String email);

    UserInform findByUsername(String username);
}