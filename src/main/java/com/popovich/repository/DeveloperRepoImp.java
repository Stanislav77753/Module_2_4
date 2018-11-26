package com.popovich.repository;

import com.popovich.model.Developer;
import com.popovich.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class DeveloperRepoImp implements DeveloperRepo {

    @Override
    public List<Developer> getAll() {
        List<Developer> developers;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        developers = session.createQuery("FROM Developer").list();
        transaction.commit();
        session.close();
        return developers;
    }


}
