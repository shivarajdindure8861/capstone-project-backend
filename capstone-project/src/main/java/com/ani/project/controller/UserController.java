package com.ani.project.controller;

import com.ani.project.dto.UserDTO;
import com.ani.project.service.UserService;
import com.ani.project.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Status registerUser(@Valid @RequestBody UserDTO userDto) {
        return userService.registerUser(userDto);
    }

    @PostMapping("/login")
    public Status loginUser(@Valid @RequestBody UserDTO userDto) {
        return userService.loginUser(userDto);
    }

    @PostMapping("/logout")
    public Status logUserOut(@Valid @RequestBody UserDTO userDto) {
        return userService.logUserOut(userDto);
    }
}