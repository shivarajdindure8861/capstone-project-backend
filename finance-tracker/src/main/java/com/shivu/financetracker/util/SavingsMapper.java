package com.shivu.financetracker.util;

import org.springframework.stereotype.Component;

import com.shivu.financetracker.domain.Savings;
import com.shivu.financetracker.dto.SavingsDto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SavingsMapper {
    private final UserMapper userMapper;

    public Savings toDomain(SavingsDto dto) {
        return Savings.builder()
                .category(dto.getCategory())
                .goal(dto.getGoal())
                .currAmt(dto.getCurrAmt())
                .target(dto.getTarget())
                .processedDate(dto.getProcessedDate())
                .build();
    }

    public SavingsDto toDto(Savings domain) {
        return new SavingsDto(
                domain.getSavingsId(),
                domain.getCategory(),
                domain.getGoal(),
                domain.getCurrAmt(),
                domain.getTarget(),
                domain.getProcessedDate(),
                userMapper.toDto(domain.getUser()));
    }
}
