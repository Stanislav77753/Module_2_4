package com.popovich.service;

import com.popovich.model.Account;
import com.popovich.repository.AccountRepoImp;

import java.util.List;

public class AccountService {
    private AccountRepoImp accountRepoImp = new AccountRepoImp();

    public void save(Account account){
        accountRepoImp.save(account);
    }

    public List<Account> getAll(){
        return accountRepoImp.getAll();
    }

    public void delete(Account account){
        accountRepoImp.delete(account);
    }
}
