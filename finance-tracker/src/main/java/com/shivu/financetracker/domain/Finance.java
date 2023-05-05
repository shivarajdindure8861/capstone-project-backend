package com.shivu.financetracker.domain;

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
import javax.validation.constraints.Size;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import com.shivu.financetracker.util.FinanceType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "finance")
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Finance type cannot be null")
    @Column(name = "Income_Expense")
    @Enumerated(EnumType.STRING)
    private FinanceType financeType;
    @NotBlank(message = "tag cannot be blank")
    @Size(min = 3, max = 50, message = "tag should contain")
    @Column(name = "tag")
    private String tag;
    @NotNull(message = "date can't be blank")
    @PastOrPresent(message = "date can't be future")
    @Column(name = "processed_Date")
    private LocalDate processedDate;
    @NotNull(message = "amount cannot be null")
    @Positive(message = "amount cannot be negative")
    @Column(name = "amount")
    private Double amount;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
