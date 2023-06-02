package com.ani.project.service;

import java.util.List;

import com.ani.project.dto.SavingsDto;
import com.ani.project.dto.SavingsUserDto;
import com.ani.project.exception.FinanceNotFoundException;
import com.ani.project.exception.SavingsNotFoundException;
import com.ani.project.exception.UserNotFoundException;

public interface SavingsService {
    Integer createNewSavings(SavingsDto savingsDto);

    Integer createNewSavings(SavingsUserDto dto);

    List<SavingsDto> all();

    Integer deleteSavings(Long id) throws FinanceNotFoundException;

    SavingsDto fetchSavingsDetails(Long id) throws SavingsNotFoundException;

    Integer updateSavings(SavingsDto finance);

    List<SavingsDto> allUserSavings(Long id) throws UserNotFoundException;
    
}
