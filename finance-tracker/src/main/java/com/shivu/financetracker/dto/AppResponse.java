package com.shivu.financetracker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AppResponse<T> {
    private String sts;
    private String msg;
    private T bd;
}
