package com.shivu.financetracker.util;

import org.springframework.stereotype.Component;

import com.shivu.financetracker.domain.Finance;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class FinanceMapper {
    private final UserMapper userMapper;

    
}
