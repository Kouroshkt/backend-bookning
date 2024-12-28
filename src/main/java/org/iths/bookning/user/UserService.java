package org.iths.bookning.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(UserInform userInform) {
        userRepository.save(userInform);
    }

    public Iterable<UserInform> allUser() {
        return userRepository.findAll();
    }

    public UserInform getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserInform getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
