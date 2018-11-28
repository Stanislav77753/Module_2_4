package com.popovich.repository.RepoImp;

import com.popovich.model.Account;
import com.popovich.repository.AccountRepo;
import com.popovich.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class AccountRepoImp implements AccountRepo {

    @Override
    public List<Account> getAll() {
        List<Account> accounts;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        accounts = session.createQuery("FROM Account").list();
        transaction.commit();
        session.close();
        return accounts;
    }


}
