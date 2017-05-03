package com.water.test;

import com.water.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by Water on 17/5/2.
 * Email:water471871679@gmail.com
 */
public class Test {
    @org.junit.Test
    public void testHibernate() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //
        User user = new User();
        user.setName("你好啊");
        user.setUid(System.currentTimeMillis()+"");
        //
        session.save(user);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
