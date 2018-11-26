package com.popovich.model;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity{
    private String accountData;
    private Developer developer;

    public Account(){
        super();
    }

    public Account(String accountData){
        super();
        this.accountData = accountData;
    }

    @Column(name = "account_data")
    public String getAccountData() {
        return accountData;
    }

    public void setAccountData(String accountData) {
        this.accountData = accountData;
    }

    @OneToOne(mappedBy = "account")
    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}
