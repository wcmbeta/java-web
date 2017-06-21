package com.water.test;

import com.water.entity.BaseDict;
import com.water.entity.Customer;
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
//        User user = new User();
//        user.setName("张龙");
//        session.save(user);

        //delete
//        ArrayList<User> list = (ArrayList<User>) session
//                .createQuery("select user from User user where user.name like ?")
//                .setParameter(0, "%龙%")
//                .list();
//        if (list != null && !list.isEmpty()) {
//            LogUtils.info(list.get(0).toString());
//            session.delete(list.get(0));
//        }

//        //Customer
        Customer customer = new Customer();
        customer.setCust_name("测试保存");
        BaseDict baseDictIndustry = new BaseDict();
        baseDictIndustry.setDict_id("2");
        customer.setCust_industry(baseDictIndustry);
        BaseDict baseDictLevel = new BaseDict();
        baseDictLevel.setDict_id("12");
        customer.setCust_level(baseDictLevel);
        BaseDict baseDictSource = new BaseDict();
        baseDictSource.setDict_id("18");
        customer.setCust_source(baseDictSource);

        session.save(customer);

        //delete
//        ArrayList<Customer> list = (ArrayList<Customer>) session
//                .createQuery("select customer from customer customer where customer.cust_name like ?")
//                .setParameter(0, "%测试%")
//                .list();
//        if (list != null && !list.isEmpty()) {
//            LogUtils.info(list.get(0).toString());
//            session.delete(list.get(0));
//        }


        //Base_Dict
//        BaseDict baseDictIndustry = new BaseDict();
//        baseDictIndustry.setDict_id("20");
//        baseDictIndustry.setDict_type_name("客户来源");
//        baseDictIndustry.setDict_type_code("005");
//        baseDictIndustry.setDict_item_name("测试");
//        baseDictIndustry.setDict_enable('1');
//        baseDictIndustry.setDict_sort(7);
//        session.save(baseDictIndustry);
        //删除
//        ArrayList<BaseDict> list = (ArrayList<BaseDict>) session
//                .createQuery("select customer from BaseDict customer where customer.dict_item_name like ?")
//                .setParameter(0, "%测试%")
//                .list();
//        if (list != null && !list.isEmpty()) {
//            LogUtils.info(list.get(0).toString());
//            session.delete(list.get(0));
//        }



        transaction.commit();
        session.close();

    }
}
