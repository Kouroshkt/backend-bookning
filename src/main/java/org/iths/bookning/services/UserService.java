package org.iths.bookning.services;

import org.iths.bookning.entities.UserInformation;
import org.iths.bookning.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(UserInformation userInformation) {
        userRepository.save(userInformation);
    }

    public Iterable<UserInformation> allUser() {
        return userRepository.findAll();
    }

    public UserInformation getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserInformation getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
