package com.shivu.financetracker.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeDto {
    private Long incomeId;
    @NotEmpty(message = "source cannot be empty")
    @NotNull(message = "source cannot be null")
    @NotBlank(message = "source cannot be blank")
    private String source;
    @NotEmpty(message = "amount cant be empty")
    @NotBlank(message = "amount cant be zero")
    @NotBlank(message = "amount is mandetory")
    private Double amount;

}
