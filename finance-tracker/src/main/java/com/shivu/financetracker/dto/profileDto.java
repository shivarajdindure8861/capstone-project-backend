package com.shivu.financetracker.dto;

import java.util.List;

import com.shivu.financetracker.domain.LinkedAccounts;
import com.shivu.financetracker.domain.LinkedCards;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class profileDto {
    private String name;
    private String email;

    private List<LinkedCards> cards;
    private List<LinkedAccounts> accounts;

}
