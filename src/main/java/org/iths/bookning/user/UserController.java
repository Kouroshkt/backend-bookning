package org.iths.bookning.user;

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
    public void addUser(@RequestBody UserInformation userInformation) {
        System.out.println(userInformation);
        userService.addUser(userInformation);
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

}
