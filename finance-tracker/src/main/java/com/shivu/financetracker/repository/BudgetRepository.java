package com.shivu.financetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivu.financetracker.domain.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

}
