package com.shivu.financetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivu.financetracker.domain.Investment;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {

}
