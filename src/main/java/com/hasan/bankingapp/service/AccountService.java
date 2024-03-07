package com.hasan.bankingapp.service;

import com.hasan.bankingapp.dto.AccountDto;


public interface AccountService {
    AccountDto creAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

}
