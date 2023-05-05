package com.shivu.financetracker.exception;

public class SavingsNotFoundException extends RuntimeException {
    public SavingsNotFoundException(String msg) {
        super(msg);
    }
}
