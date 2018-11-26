package com.popovich.repository;

import com.popovich.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public interface Repository<E> {
    default void save(E e){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(e);
        transaction.commit();
        session.close();
    }
    default void delete(E e){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(e);
        transaction.commit();
        session.close();
    }

    default void update(E e){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(e);
        transaction.commit();
        session.close();
    }

   List<E> getAll();

    
}
