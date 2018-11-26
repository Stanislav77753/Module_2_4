package com.popovich.controller;

import com.popovich.model.Account;
import com.popovich.service.AccountService;

import java.util.List;

public class AccountController {
    private AccountService accountService = new AccountService();
    
    public void save(Account account){
        accountService.save(account);
    }

    public List<Account> getAll(){
        return accountService.getAll();
    }

    public void delete(Account account){
        accountService.delete(account);
    }
}
