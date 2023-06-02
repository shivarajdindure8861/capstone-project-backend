package com.shivu.financetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivu.financetracker.domain.LinkedAccounts;

public interface LinkedAccountsRepository extends JpaRepository<LinkedAccounts, Long> {

}
