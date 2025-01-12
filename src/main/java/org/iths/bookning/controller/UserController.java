package org.iths.bookning.controller;

import org.iths.bookning.entities.UserInformation;
import org.iths.bookning.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    public Iterable<UserInformation> allUser() {
        return userService.allUser();
    }
    @PostMapping("/adduser")
    public ResponseEntity<?> addUser(@RequestBody UserInformation userInformation) {
        try {
            if (userService.findUserByEmail(userInformation.getEmail())) {
                return ResponseEntity.status(409).body("E-postadressen är redan registrerad.");
            }
            UserInformation savedUser = userService.addUser(userInformation);
            return ResponseEntity.ok(savedUser);
        } catch (IllegalArgumentException e) {
            System.out.println("Fel vid validering: " + e.getMessage());
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            System.err.println("Internt fel: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(500).body("Ett internt fel inträffade. Försök igen senare.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserInformation> login(@RequestBody UserInformation userInformation) {
        UserInformation userLogin = userService.getUserByUsername(userInformation.getUsername());
        if (userLogin != null && userLogin.getPassword().equals(userInformation.getPassword())) {
            return ResponseEntity.ok(userLogin);
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @GetMapping("/getuser/{email}")
    public UserInformation getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }
    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

}
