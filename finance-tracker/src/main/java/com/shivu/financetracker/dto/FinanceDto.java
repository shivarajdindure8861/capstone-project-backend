package com.shivu.financetracker.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

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
    @NotNull(message = "financetype cannot be null")
    private FinanceType financeType;
    @NotNull(message = "tag cannot be null")
    private String tag;
    @PastOrPresent(message = "date can't be future")
    @NotNull(message = "date cannot be blank")
    private LocalDate invDt;
    @NotNull(message = "amount cannot be null")
    private Double amt;
    private UserDTO userDto;
}
