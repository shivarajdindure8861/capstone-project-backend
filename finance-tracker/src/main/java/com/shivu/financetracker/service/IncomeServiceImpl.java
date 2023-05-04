package com.shivu.financetracker.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.shivu.financetracker.domain.Income;
import com.shivu.financetracker.dto.IncomeDto;
import com.shivu.financetracker.exception.ResourceNotFoundException;
import com.shivu.financetracker.repository.IncomeRepository;
import com.shivu.financetracker.repository.UserRepository;
import com.shivu.financetracker.util.IncomeMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;
    private final UserRepository userRepository;
    private final IncomeMapper mapper;

    @Override
    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    @Override
    public Income getIncomeById(Long incomeId) throws ResourceNotFoundException {
        return incomeRepository.findById(incomeId)
                .orElseThrow(() -> new ResourceNotFoundException("income with id " + incomeId + " is not present"));

    }

    @Override
    public Income getIncomeByUserId(Long userId) throws ResourceNotFoundException {
        Optional<Income> incomeOptional = incomeRepository.findById(userId);
        return incomeOptional.get();

    }

    @Override
    public void updateIncome(Long incomeId, Income incomeDetails) throws ResourceNotFoundException {

        throw new UnsupportedOperationException("Unimplemented method 'updateIncome'");
    }

    @Override
    public void deleteIncomeByIncomeId(Long incomeId) throws ResourceNotFoundException {

        throw new UnsupportedOperationException("Unimplemented method 'deleteIncomeByIncomeId'");
    }

    @Override
    public Integer addIncome(IncomeDto dto) {
        Income income = incomeRepository.findById(dto.getIncomeId())
                .orElseThrow(() -> new ResourceNotFoundException("income is not found"));

        return 1;
    }
}
