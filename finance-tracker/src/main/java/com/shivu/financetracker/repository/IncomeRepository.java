package com.shivu.financetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivu.financetracker.domain.Income;

public interface IncomeRepository extends JpaRepository<Income, Long> {

}
