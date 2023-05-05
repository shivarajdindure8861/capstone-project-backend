package com.shivu.financetracker.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SavingsUserDto {
    private Long id;
    private String category;
    private Double goal;
    private Double currAmt;
    private LocalDate processedDate;
    private LocalDate target;
    private Long userId;
}
