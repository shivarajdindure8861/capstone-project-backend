package com.ani.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.project.domain.Savings;

public interface SavingsRepository extends JpaRepository<Savings ,Long> {
    
}