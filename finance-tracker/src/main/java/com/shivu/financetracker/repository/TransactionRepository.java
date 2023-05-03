package com.shivu.financetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivu.financetracker.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
