package com.shivu.financetracker.util;

import org.springframework.stereotype.Component;

import com.shivu.financetracker.domain.Finance;
import com.shivu.financetracker.dto.FinanceDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class FinanceMapper {
    private final UserMapper userMapper;

    public Finance toDomain(FinanceDto dto) {
        return Finance.builder()
                .amount(dto.getAmt())
                .amount(dto.getAmt())
                .tag(dto.getTag()).id(dto.getId()).financeType(dto.getFinanceType()).processedDate(dto.getInvDt())
                .user(userMapper.toDomain(dto.getUserDto()))
                .build();
    }

    public FinanceDto toDto(Finance domain) {
        return new FinanceDto(domain.getId(),
                domain.getFinanceType(),
                domain.getTag(),
                domain.getProcessedDate(),
                domain.getAmount(),
                userMapper.todto(domain.getUser()));
    }

}
