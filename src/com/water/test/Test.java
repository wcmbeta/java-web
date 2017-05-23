package com.water.test;

import com.water.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 测试
 * Created by Water on 17/5/2.
 * Email:water471871679@gmail.com
 */
public class Test {
    private static Logger logger = LogManager.getLogger(Test.class);
    /**
     * 增
     */
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

    /**
     * 查,删,改
     */
    @org.junit.Test
    public void testHibernate2() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //
        User user = session.get(User.class,1);
        logger.info(user.getId() + "--" + user.getName());
        //
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
