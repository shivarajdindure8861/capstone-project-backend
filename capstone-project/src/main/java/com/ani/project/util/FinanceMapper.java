package com.ani.project.util;

import org.springframework.stereotype.Component;

import com.ani.project.domain.Finance;
import com.ani.project.dto.FinanceDto;

@Component
public class FinanceMapper {

    private final UserMapper userMapper;

    public FinanceMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Finance toDomain(FinanceDto dto) {
        return Finance.builder()
                .amount(dto.getAmt())
                .tag(dto.getTag())
                .id(dto.getId())
                .financeType(dto.getFinanceType())
                .processedDate(dto.getInvDt())
                .user(userMapper.toDomain(dto.getUserDto()))
                .build();
    }

    public FinanceDto toDto(Finance domain) {
        return new FinanceDto(
                domain.getId(),
                domain.getFinanceType(),
                domain.getTag(),
                domain.getProcessedDate(),
                domain.getAmount(),
                userMapper.toDto(domain.getUser()));
    }
}