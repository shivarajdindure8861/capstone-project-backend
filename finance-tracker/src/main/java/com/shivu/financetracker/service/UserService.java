package com.shivu.financetracker.service;

import java.util.List;
import com.shivu.financetracker.dto.CreateUserdto;
import com.shivu.financetracker.dto.UserListDto;

public interface UserService {
    Integer createNewUser(CreateUserdto dto);

    List<CreateUserdto> findUsers();

    List<UserListDto> findCustomer(String ss);
}
