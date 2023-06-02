package com.ani.project.service;

import com.ani.project.domain.User;
import com.ani.project.dto.UserDTO;
import com.ani.project.repository.UserRepository;
import com.ani.project.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

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
}
