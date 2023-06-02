package com.ani.project.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.ani.project.util.FinanceType;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "finance")
public class Finance {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @NotNull(message = "Finance type cannot be null")
    @Column(name = "income_expenses")
    @Enumerated(EnumType.STRING)
    private FinanceType financeType;
    
    @NotBlank(message = "Tag cannot be blank")
    @Size(min = 3, max = 50, message = "Tag must be between 3 and 50 characters long")
    @Column(name = "tag")
    private String tag;
    
    @NotNull(message = "Processed date cannot be null")
    @PastOrPresent(message = "Processed date cannot be in the future")
    @Column(name = "processed_date")
    private LocalDate processedDate;
    
    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    @Column(name = "amount")
    private Double amount;
    
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;   
}