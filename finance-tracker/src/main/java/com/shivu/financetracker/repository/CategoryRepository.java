package com.shivu.financetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivu.financetracker.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
