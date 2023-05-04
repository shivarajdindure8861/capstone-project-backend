package com.shivu.financetracker.service;

import java.util.List;

import com.shivu.financetracker.dto.FinanceDto;
import com.shivu.financetracker.dto.FinanceUserDto;
import com.shivu.financetracker.exception.FinanceNotFoundException;
import com.shivu.financetracker.exception.UserNotFoundException;

public interface FinanceService {
    Integer createNewFinance(FinanceDto dto);

    Integer createNewFinance(FinanceUserDto dto);

    List<FinanceDto> all();

    Integer deleteFinance(Long id) throws FinanceNotFoundException;

    FinanceDto fetchFinanceDetails(Long id) throws FinanceNotFoundException;

    Integer updateFinanceDetails(FinanceDto finance);

    List<FinanceDto> allUserFinances(Long id) throws UserNotFoundException;

}
