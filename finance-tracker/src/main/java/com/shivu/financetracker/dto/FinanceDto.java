package com.shivu.financetracker.dto;

import java.time.LocalDate;

import com.shivu.financetracker.util.FinanceType;

public class FinanceDto {
    private Long id;
    private FinanceType financeType;
    private String tag;
    private LocalDate invDt;
    private Double amt;
    private UserDTO userDTO;
}
