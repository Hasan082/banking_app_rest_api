package com.hasan.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hasan.bankingapp.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {

}
