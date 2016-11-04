package com.ncblog;

import com.ncblog.domain.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import java.util.Map;

/**
 * Created by Администратор on 04.11.2016
 */
public class Main {
    public static void main(String args[]) {
        User ura = new User("Minin", "123");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(ura);
        int id = ura.getUser_id();
        transaction.commit();

        User uraReborn = (User) session.get(User.class, id);
        System.out.println(uraReborn.getLogin());
        session.close();
    }
}
