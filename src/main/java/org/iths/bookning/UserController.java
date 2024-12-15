package org.iths.bookning;

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
    public Iterable<UserInform> allUser() {
        return userService.allUser();
    }
    @PostMapping("/adduser")
    public void addUser(@RequestBody UserInform userInform) {
        System.out.println(userInform);
        userService.addUser(userInform);
    }
    @PostMapping("/login")
    public ResponseEntity<UserInform> login(@RequestBody UserInform userInform) {
        UserInform userLogin = userService.getUserByUsername(userInform.getUsername());
        if (userLogin != null && userLogin.getPassword().equals(userInform.getPassword())) {
            return ResponseEntity.ok(userLogin);
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @GetMapping("/getuser/{email}")
    public UserInform getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

}
