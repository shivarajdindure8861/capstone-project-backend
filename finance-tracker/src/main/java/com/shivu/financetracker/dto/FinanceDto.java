package com.shivu.financetracker.dto;

import java.time.LocalDate;

import com.shivu.financetracker.util.FinanceType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FinanceDto {
    private Long id;
    private FinanceType financeType;
    private String tag;
    private LocalDate invDt;
    private Double amt;
    private UserDTO userDto;
}
