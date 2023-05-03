package com.shivu.financetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivu.financetracker.domain.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
