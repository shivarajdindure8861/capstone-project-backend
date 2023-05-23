package com.shivu.financetracker.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.shivu.financetracker.domain.Finance;
import com.shivu.financetracker.domain.User;
import com.shivu.financetracker.dto.FinanceDto;
import com.shivu.financetracker.dto.FinanceUserDto;
import com.shivu.financetracker.exception.FinanceNotFoundException;
import com.shivu.financetracker.exception.UserNotFoundException;
import com.shivu.financetracker.repository.FinanceRepository;
import com.shivu.financetracker.repository.UserRepository;
import com.shivu.financetracker.util.FinanceMapper;
import com.shivu.financetracker.util.FinanceType;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class FinanceServiceImpl implements FinanceService {

    private final FinanceRepository repository;
    private final UserRepository userRepository;
    private final FinanceMapper mapper;

    @Override
    public Integer createNewFinance(FinanceDto dto) {
        repository.save(mapper.toDomain(dto));
        return 1;
    }

    @Override
    public List<FinanceDto> all() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Integer deleteFinance(Long id) throws FinanceNotFoundException {
        repository.deleteById(id);
        return 1;
    }

    @Override
    public FinanceDto fetchFinanceDetails(Long id) throws FinanceNotFoundException {
        Optional<Finance> op = repository.findById(id);
        return mapper.toDto(op.orElseThrow(() -> new FinanceNotFoundException("Finance " + id + " Not Found")));
    }

    @Override
    public Integer updateFinance(FinanceDto finance) {
        repository.save(mapper.toDomain(finance));
        return 1;
    }

    @Override
    public Integer createNewFinance(FinanceUserDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));

        Finance finance = new Finance();
        finance.setAmount(dto.getAmt());
        finance.setFinanceType(dto.getFinanceType());
        finance.setId(dto.getUserId());
        finance.setTag(dto.getTag());
        finance.setProcessedDate(dto.getInvDt());
        finance.setUser(user);

        repository.save(finance);

        return 1;
    }

    @Override
    public Double getTotalIncome() {
        return repository.getTotalAmountByType(FinanceType.INCOME);
    }

    @Override
    public Double getTotalExpenses() {
        return repository.getTotalAmountByType(FinanceType.EXPENSES);
    }

    @Override
    public List<User> allUserFinances(Long id) {
        return repository.findAllUserById(id);

    }
}