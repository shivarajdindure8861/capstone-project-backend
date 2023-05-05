package com.shivu.financetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivu.financetracker.domain.Finance;
import com.shivu.financetracker.util.FinanceType;

public interface FinanceRepository extends JpaRepository<Finance, Long> {
    @Query("SELECT SUM(f.amount) FROM Finance f WHERE f.financeType = :type")
    Double getTotalAmountByType(@Param("type") FinanceType type);

    @Query("SELECT SUM(f.amount) FROM Finance f WHERE f.financeType = :type AND f.tag = :tag")
    Double getTotalAmountByTypeAndTag(@Param("type") FinanceType type, @Param("tag") String tag);

    @Query("SELECT SUM(f.amount) FROM Finance f WHERE f.financeType = :type AND f.tag = :tag AND f.user.id = :userId")
    Double getTotalAmountByTypeAndTagAndUser(@Param("type") FinanceType type, @Param("tag") String tag,
            @Param("userId") Long userId);

    @Query("SELECT f.tag, SUM(f.amount) FROM Finance f WHERE f.financeType = :financeType GROUP BY f.tag")
    List<Object[]> getTotalAmountByTag(@Param("financeType") FinanceType financeType);

    @Query("SELECT f.financeType, f.tag, SUM(f.amount) "
            + "FROM Finance f "
            + "WHERE f.financeType = :type "
            + "GROUP BY f.financeType, f.tag")
    List<Object[]> findTotalAmountByTagAndType(@Param("type") FinanceType type);
}
