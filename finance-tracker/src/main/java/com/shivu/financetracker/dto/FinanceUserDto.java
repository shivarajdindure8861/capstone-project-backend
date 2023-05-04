package com.shivu.financetracker.dto;

import java.time.LocalDate;

import com.shivu.financetracker.util.FinanceType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FinanceUserDto {
    private String client;
    private LocalDate invDt;
    private FinanceType financeType;
    private String tag;
    private Double amt;
    private Long userId;

}
