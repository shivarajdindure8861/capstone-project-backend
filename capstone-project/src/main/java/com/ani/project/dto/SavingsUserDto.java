package com.ani.project.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SavingsUserDto {
    private Long id;
    private String category;
    private Double goal;
    private Double currAmt;
    private LocalDate processedDate;
    private LocalDate target;
    private Long userId;
    
}