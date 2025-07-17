package com.example.userAuth.controller;
import com.example.userAuth.model.User;
import com.example.userAuth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Registration endpoint
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // Login endpoint
    @PostMapping("/login")
    public String loginUser(@RequestBody User loginRequest) {
        return userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestBody User changePassword) {
        return userService.changePassword(changePassword.getEmail(), changePassword.getPassword(), );
    }

}
