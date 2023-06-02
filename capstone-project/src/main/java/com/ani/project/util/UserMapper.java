package com.ani.project.util;

import org.springframework.stereotype.Component;

import com.ani.project.domain.User;
import com.ani.project.dto.UserDTO;

@Component
public class UserMapper {

    public User toDomain(UserDTO dto) {
        return User.builder()
        .id(dto.getId())
        .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }

    public UserDTO toDto(User domain) {
        return new UserDTO(domain.getId(), domain.getName(), domain.getEmail(), domain.getPassword());
    }
}