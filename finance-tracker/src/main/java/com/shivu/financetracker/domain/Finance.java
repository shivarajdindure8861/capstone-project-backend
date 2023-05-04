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
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
    @Column(name = "Income_Expense")
    @Enumerated(EnumType.STRING)
    private FinanceType financeType;
    @Column(name = "tag")
    private String tag;
    @Column(name = "processed_Date")
    private LocalDate processedDate;
    @Column(name = "amount")
    private Double amount;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
