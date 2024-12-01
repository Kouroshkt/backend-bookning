package org.iths.bookning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

}
