package com.ani.project.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@Table(name = "savings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Savings {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Category is required")
    @Column(name = "saving_types")
    private String category;

    @NotNull(message = "Goal amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Goal amount must be greater than 0")
    @Column(name = "goal_amount")
    private Double goal;

    @NotNull(message = "Current amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Current amount must be greater than 0")
    @Column(name = "curr_amount")
    private Double currAmt;

    @NotNull(message = "Target date is required")
    @FutureOrPresent(message = "Target date must be in the present or future")
    @Column(name = "target_date")
    private LocalDate target;

    @PastOrPresent(message = "Processed date must be in the past or present")
    @Column(name = "processed_date")
    private LocalDate processedDate;

    @NotNull(message = "User is required")
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

}