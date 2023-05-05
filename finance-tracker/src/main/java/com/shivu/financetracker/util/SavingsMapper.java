package com.shivu.financetracker.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.shivu.financetracker.domain.Savings;
import com.shivu.financetracker.dto.SavingsDto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SavingsMapper {
    private final UserMapper userMapper;

    public Savings toDomain(SavingsDto dto) {
        Savings domain = new Savings();
        BeanUtils.copyProperties(dto, domain);
        domain.setUser(userMapper.toDomain(dto.getUserDto()));
        return domain;
    }

    public SavingsDto toDto(Savings domain) {
        SavingsDto dto = new SavingsDto();
        BeanUtils.copyProperties(domain, dto);
        dto.setUserDto(userMapper.toDto(domain.getUser()));
        return dto;
    }
}
