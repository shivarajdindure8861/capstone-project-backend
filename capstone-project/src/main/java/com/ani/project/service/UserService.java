package com.ani.project.service;

import com.ani.project.dto.UserDTO;

import com.ani.project.util.Status;

public interface UserService {
    Status registerUser(UserDTO userDto);
    Status loginUser(UserDTO userDto);
    Status logUserOut(UserDTO userDto);
}