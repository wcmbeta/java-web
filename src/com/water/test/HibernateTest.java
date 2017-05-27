package com.water.test;

import com.water.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * Created by Water on 17/5/23.
 * Email:water471871679@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @org.junit.Test
    public void test() {
//        Configuration configuration = new Configuration().configure();
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //save
        User user = new User();
        user.setName("张龙");
        session.save(user);

        //delete
//        ArrayList<User> list = (ArrayList<User>) session
//                .createQuery("select user from User user where user.name like ?")
//                .setParameter(0, "%龙%")
//                .list();
//        if (list != null && !list.isEmpty()) {
//            LogUtils.info(list.get(0).toString());
//            session.delete(list.get(0));
//        }


        transaction.commit();
        session.close();

    }
}
