package com.ani.project.service;

import java.util.List;

import com.ani.project.dto.FinanceDto;
import com.ani.project.exception.UserNotFoundException;
import com.ani.project.exception.FinanceNotFoundException;
import com.ani.project.dto.FinanceUserDto;

public interface FinanceService {
    Integer createNewFinance(FinanceDto finance);

    Integer createNewFinance(FinanceUserDto dto);

    List<FinanceDto> all();

    Integer deleteFinance(Long id) throws FinanceNotFoundException;

    FinanceDto fetchFinanceDetails(Long id) throws FinanceNotFoundException;

    Integer updateFinance(FinanceDto finance);

    List<FinanceDto> allUserFInances(Long id) throws UserNotFoundException;

    Double getTotalIncome();
    Double getTotalExpenses();

    

    
}