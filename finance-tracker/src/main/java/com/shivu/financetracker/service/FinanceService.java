package com.shivu.financetracker.service;

import com.shivu.financetracker.dto.FinanceDto;

public interface FinanceService {
    Integer createNewFinance(FinanceDto dto);

}
