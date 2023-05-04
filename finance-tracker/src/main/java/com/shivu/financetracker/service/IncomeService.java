package com.shivu.financetracker.service;

import java.util.List;

import com.shivu.financetracker.domain.Income;
import com.shivu.financetracker.dto.IncomeDto;
import com.shivu.financetracker.exception.ResourceNotFoundException;

public interface IncomeService {
    public List<Income> getAllIncomes();

    public Income getIncomeById(Long incomeId) throws ResourceNotFoundException;

    public Income getIncomeByUserId(Long userId) throws ResourceNotFoundException;

    public Integer addIncome(IncomeDto dto);

    public void updateIncome(Long incomeId, Income incomeDetails) throws ResourceNotFoundException;

    public void deleteIncomeByIncomeId(Long incomeId) throws ResourceNotFoundException;
}
