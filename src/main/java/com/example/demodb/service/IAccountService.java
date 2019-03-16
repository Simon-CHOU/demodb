package com.example.demodb.service;

import com.example.demodb.model.Account;

import java.util.List;


public interface IAccountService {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
