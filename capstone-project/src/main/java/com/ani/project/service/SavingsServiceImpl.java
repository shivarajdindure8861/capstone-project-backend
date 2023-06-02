package com.ani.project.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ani.project.domain.Savings;
import com.ani.project.domain.User;
import com.ani.project.dto.SavingsDto;
import com.ani.project.dto.SavingsUserDto;
import com.ani.project.exception.FinanceNotFoundException;
import com.ani.project.exception.SavingsNotFoundException;
import com.ani.project.exception.UserNotFoundException;
import com.ani.project.repository.SavingsRepository;
import com.ani.project.repository.UserRepository;
import com.ani.project.util.SavingsMapper;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class SavingsServiceImpl implements SavingsService {

    private final SavingsRepository repository;
    private final UserRepository userRepository;
    private final SavingsMapper mapper;

    @Override
    public Integer createNewSavings(SavingsDto dto) {
        repository.save(mapper.toDomain(dto));
        return 1;
    }

    @Override
    public List<SavingsDto> all() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Integer deleteSavings(Long id) throws SavingsNotFoundException {
        repository.deleteById(id);
        return 1;
    }

    @Override
    public SavingsDto fetchSavingsDetails(Long id) throws SavingsNotFoundException {
        Optional<Savings> op = repository.findById(id);
        return mapper.toDto(op.orElseThrow(() -> new FinanceNotFoundException("Finance " + id + " Not Found")));
    }

    @Override
    public Integer updateSavings(SavingsDto finance) {
        repository.save(mapper.toDomain(finance));
        return 1;
    }

    @Override
    public Integer createNewSavings(SavingsUserDto dto) {

        User user = userRepository.findById(dto.getUserId())
                                        .orElseThrow(() -> new UserNotFoundException("User Not Found"));

        Savings savings = new Savings();
        savings.setCategory(dto.getCategory());
        savings.setGoal(dto.getGoal());
        savings.setCurrAmt(dto.getCurrAmt());
        savings.setTarget(dto.getTarget());        
        savings.setProcessedDate(dto.getProcessedDate());
        savings.setUser(user);

        repository.save(savings);

        return 1;
    }

    @Override
    public List<SavingsDto> allUserSavings(Long id) throws UserNotFoundException {
        return repository.findById(id)
                        .stream()
                        .map(mapper::toDto)
                        .collect(Collectors.toList());
    }
}