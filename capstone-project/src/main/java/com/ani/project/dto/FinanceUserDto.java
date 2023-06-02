package com.ani.project.dto;

import java.time.LocalDate;

import com.ani.project.util.FinanceType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FinanceUserDto {
    private String client;
    private LocalDate invDt;
    private FinanceType financeType;
    private String Tag;
    private Double amt;
    private Long userId;
}