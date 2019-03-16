package com.example.demodb.controller;

import com.example.demodb.model.Account;
import com.example.demodb.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    private AccountServiceImpl accountService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountService.findAccountList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.findAccountById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        Account account = new Account();
        account.setId(id);
        account.setMoney(money);
        account.setName(name);
        int t = accountService.update(account);
        if (t == 1) {
            return account.toString();
        } else {
            return "update failed";
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name", required = true) String name,
                              @RequestParam(value = "money", required = true) double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        int t = accountService.add(account);
        if (t == 1) {
            return account.toString();
        } else {
            return "add failed";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteAccount(@PathVariable("id") int id) {
        Account account = new Account();
        account.setId(id);
        int t = accountService.delete(account.getId());
        if (t == 1) {
            return account.toString();
        } else {
            return "delete failed";
        }
    }
}