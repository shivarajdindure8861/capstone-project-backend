package com.shivu.financetracker.service;

import java.util.List;

import com.shivu.financetracker.domain.User;
import com.shivu.financetracker.dto.FinanceDto;
import com.shivu.financetracker.dto.FinanceUserDto;
import com.shivu.financetracker.exception.FinanceNotFoundException;

public interface FinanceService {
    Integer createNewFinance(FinanceDto finance);

    Integer createNewFinance(FinanceUserDto dto);

    List<FinanceDto> all();

    FinanceDto fetchFinanceDetails(Long id) throws FinanceNotFoundException;

    List<User> allUserFinances(Long id);

    Integer deleteFinance(Long id) throws FinanceNotFoundException;

    Integer updateFinance(FinanceDto finance);

    Double getTotalIncome();

    Double getTotalExpenses();

}
