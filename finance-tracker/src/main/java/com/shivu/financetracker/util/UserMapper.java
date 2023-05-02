package com.shivu.financetracker.util;

import org.springframework.stereotype.Component;

import com.shivu.financetracker.domain.User;
import com.shivu.financetracker.dto.UserListDto;

@Component
public class UserMapper {
    public User toDomain(UserListDto dto) {
        return User.builder()
                .id(dto.getId())
                .userName(dto.getName())
                .email(dto.getEmail())
                .build();
    }

    public UserListDto toDto(User domain) {
        return new UserListDto(domain.getId(), domain.getUserName(), domain.getEmail());
    }
}
