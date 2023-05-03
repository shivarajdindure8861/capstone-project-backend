package com.shivu.financetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivu.financetracker.domain.Savings;

public interface SavingsRepository extends JpaRepository<Savings, Long> {

}
