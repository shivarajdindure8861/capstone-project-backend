package com.shivu.financetracker.service;

import java.util.List;

import com.shivu.financetracker.dto.SavingsDto;
import com.shivu.financetracker.dto.SavingsUserDto;
import com.shivu.financetracker.exception.FinanceNotFoundException;
import com.shivu.financetracker.exception.SavingsNotFoundException;
import com.shivu.financetracker.exception.UserNotFoundException;

public interface SavingsService {
    Integer createNewSavings(SavingsDto savingsDto);

    Integer createNewSavings(SavingsUserDto dto);

    List<SavingsDto> all();

    Integer deleteSavings(Long id) throws FinanceNotFoundException;

    SavingsDto fetchSavingsDetails(Long id) throws SavingsNotFoundException;

    Integer updateSavings(SavingsDto finance);

    List<SavingsDto> allUserSavings(Long id) throws UserNotFoundException;
}
