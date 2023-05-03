package com.shivu.financetracker.service;

import java.util.List;

import com.shivu.financetracker.domain.Income;
import com.shivu.financetracker.exception.ResourceNotFoundException;

public interface IncomService {
    public List<Income> getAllIncomes();

    public Income getIncomeById(Long incomeId) throws ResourceNotFoundException;

    public Income getIncomeByUserId(Long userId) throws ResourceNotFoundException;

    public Income addIncome(Income income);

    public void updateIncome(Long incomeId, Income incomeDetails) throws ResourceNotFoundException;

    public void deleteIncomeByIncomeId(Long incomeId) throws ResourceNotFoundException;
}
