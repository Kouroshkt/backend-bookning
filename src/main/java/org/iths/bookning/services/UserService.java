package org.iths.bookning.services;

import org.iths.bookning.entities.UserInformation;
import org.iths.bookning.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserInformation addUser(UserInformation userInformation) {
        return userRepository.save(userInformation);
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

    public boolean findUserByEmail(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
