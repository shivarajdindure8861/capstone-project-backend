package com.shivu.financetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivu.financetracker.domain.Finance;

public interface FinanceRepository extends JpaRepository<Finance, Long> {

}
