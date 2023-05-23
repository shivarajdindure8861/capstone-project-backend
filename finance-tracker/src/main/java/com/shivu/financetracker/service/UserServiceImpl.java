package com.shivu.financetracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivu.financetracker.domain.User;
import com.shivu.financetracker.dto.UserDTO;
import com.shivu.financetracker.repository.UserRepository;
import com.shivu.financetracker.util.Status;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Status registerUser(UserDTO userDto) {

        Optional<User> userOptional = userRepository.findByEmail(userDto.getEmail());
        if (userOptional.isPresent()) {
            return Status.USER_ALREADY_EXISTS;
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);

        return Status.SUCCESS;
    }

    @Override
    public Status loginUser(UserDTO userDto) {

        Optional<User> userOptional = userRepository.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setLoggedIn(true);
            userRepository.save(user);
            return Status.SUCCESS;
        }

        return Status.FAILURE;
    }

    @Override
    public Status logUserOut(UserDTO userDto) {

        Optional<User> userOptional = userRepository.findByEmail(userDto.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setLoggedIn(false);
            userRepository.save(user);
            return Status.SUCCESS;
        }

        return Status.FAILURE;
    }

    @Override
    public Status findByEmail(UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findByEmail(userDTO.getEmail());
        if (userOptional.isPresent()) {
            return Status.SUCCESS;

        }
        return Status.FAILURE;
    }
}