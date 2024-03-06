package com.hasan.bankingapp.service.Impl;

import org.springframework.stereotype.Service;

import com.hasan.bankingapp.dto.AccountDto;
import com.hasan.bankingapp.entity.Account;
import com.hasan.bankingapp.mapper.AccountMapper;
import com.hasan.bankingapp.repository.AccountRepo;
import com.hasan.bankingapp.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }
    @Override
    public AccountDto creAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savAccount = accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savAccount);
    }
    }

    



}
