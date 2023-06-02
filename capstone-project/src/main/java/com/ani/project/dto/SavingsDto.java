package com.ani.project.dto;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class SavingsDto {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Goal amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Goal amount must be greater than 0")
    private Double goal;

    @NotNull(message = "Current amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Current amount must be greater than 0")
    private Double currAmt;

    @NotNull(message = "Target date is required")
    @FutureOrPresent(message = "Target date must be in the present or future")
    private LocalDate target;

    @PastOrPresent(message = "Processed date must be in the past or present")
    private LocalDate processedDate;

    @NotNull(message = "User is required")
    private UserDTO userDto;

}