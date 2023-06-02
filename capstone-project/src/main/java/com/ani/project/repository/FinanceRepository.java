package com.ani.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ani.project.domain.Finance;
import com.ani.project.domain.User;
import com.ani.project.util.FinanceType;

public interface FinanceRepository extends JpaRepository<Finance, Long> {


    @Query("SELECT SUM(f.amount) FROM Finance f WHERE f.financeType = :type")
    Double getTotalAmountByType(@Param("type") FinanceType type);

    

}