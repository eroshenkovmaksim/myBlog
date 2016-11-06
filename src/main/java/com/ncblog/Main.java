package com.ncblog;

import com.ncblog.dataaccess.repositories.HibernateUtil;
import com.ncblog.domain.Post;
import com.ncblog.domain.User;
import org.hibernate.*;

/**
 * Created by Администратор on 04.11.2016
 */
public class Main {
    public static void main(String args[]) {
        User ura = new User("Minin", "yura");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(ura);

        Post post = new Post("privetiki");

        post.setUser(ura);
        ura.setPost(post);

        session.save(post);
        transaction.commit();
//
//        int id = ura.getUser_id();
//
//
//        User uraReborn = (User) session.get(User.class, id);
//        System.out.println(uraReborn.getLogin());
//        session.close();
//
//        User ura2 = new User("Max", "kek");
//        GenericDao<User> dao = new GenericDao<>(User.class);
//        dao.openCurrentSessionwithTransaction();
//        dao.update(ura2);
//
//        dao.closeCurrentSessionwithTransaction();

    }
}
