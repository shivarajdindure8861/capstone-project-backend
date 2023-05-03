package com.shivu.financetracker.service;

import java.util.List;

import com.shivu.financetracker.dto.UserDTO;

import com.shivu.financetracker.util.Status;

public interface UserService {
    Status registerUser(UserDTO userDto);

    Status loginUser(UserDTO userDto);

    Status logUserOut(UserDTO userDto);
}
