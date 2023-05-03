package com.shivu.financetracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "savings")
public class Savings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "savings_id")
    private Long savingsId;
    private String goal;
    @Column(name = "target_amount")
    private Double targetAmount;
    @Column(name = "current_amount")
    private Double currentAmount;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
