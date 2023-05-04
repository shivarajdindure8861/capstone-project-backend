package com.shivu.financetracker.util;

import org.springframework.stereotype.Component;

import com.shivu.financetracker.domain.Income;
import com.shivu.financetracker.dto.IncomeDto;

@Component
public class IncomeMapper {
    public Income toDomain(IncomeDto dto) {
        return Income.builder()
                .incomeId(dto.getIncomeId())
                .source(dto.getSource())
                .amount(dto.getAmount())
                .build();
    }

    public IncomeDto toDto(Income domain) {
        return new IncomeDto(domain.getIncomeId(), domain.getSource(), domain.getAmount());
    }
}
