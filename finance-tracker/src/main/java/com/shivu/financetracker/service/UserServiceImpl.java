package com.shivu.financetracker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.shivu.financetracker.dto.CreateUserdto;
import com.shivu.financetracker.dto.UserListDto;
import com.shivu.financetracker.repository.UserRepository;
import com.shivu.financetracker.util.UserMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public Integer createUser(CreateUserdto dto) {
        return null;
    }

    @Override
    public List<CreateUserdto> findUsers() {
        return null;
    }

    @Override
    public List<UserListDto> findCustomer(String ss) {
        return null;
    }

}
