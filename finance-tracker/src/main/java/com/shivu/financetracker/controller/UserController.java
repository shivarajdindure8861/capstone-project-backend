package com.shivu.financetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shivu.financetracker.dto.UserDTO;
import com.shivu.financetracker.service.UserService;
import com.shivu.financetracker.util.Status;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("")
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