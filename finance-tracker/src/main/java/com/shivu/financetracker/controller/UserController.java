package com.shivu.financetracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivu.financetracker.dto.AppResponse;
import com.shivu.financetracker.dto.CreateUserdto;
import com.shivu.financetracker.dto.UserListDto;
import com.shivu.financetracker.service.UserService;

import lombok.AllArgsConstructor;

@RequestMapping(value = "/user")
@AllArgsConstructor
@CrossOrigin
@RestController
public class UserController {
    private final UserService service;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createNewUser(@RequestBody CreateUserdto dto) {
        final Integer sts = service.createNewUser(dto);
        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("Success")
                .msg("User Created Successfully")
                .bd(sts)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
