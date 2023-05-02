package com.shivu.financetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivu.financetracker.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
