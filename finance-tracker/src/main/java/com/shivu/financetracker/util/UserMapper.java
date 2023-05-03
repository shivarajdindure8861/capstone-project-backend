package com.shivu.financetracker.util;

import org.springframework.stereotype.Component;

import com.shivu.financetracker.domain.User;
import com.shivu.financetracker.dto.UserDTO;

@Component
public class UserMapper {
    public User toDomain(UserDTO dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }

    public UserDTO todto(User domain) {
        return new UserDTO(domain.getName(), domain.getEmail(), domain.getPassword());
    }
}
