package com.water.dao.impl;

import com.water.dao.UserDao;
import com.water.entity.User;
import com.water.utils.LogUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Water on 17/5/24.
 * Email:water471871679@gmail.com
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Override
    public void save(User user) {
        getHibernateTemplate().save(user);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public User getByName(final String name) {
        User user = null;


        //HQL
        user = getHibernateTemplate().execute(new HibernateCallback<User>() {
            @Override
            public User doInHibernate(Session session) throws HibernateException {
                String hql = "from User where name = ?";
                Query query = session.createQuery(hql);
                query.setParameter(0, name);
                User user = (User)query.uniqueResult();
                return user;
            }
        });
        LogUtils.info("HQL查询结果:"+user.toString());

        //Criteria - 离线查询
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        detachedCriteria.add(Restrictions.eq("name",name));
        List<User> listByCriteria = (List<User>) getHibernateTemplate().findByCriteria(detachedCriteria);
        if (listByCriteria != null && !listByCriteria.isEmpty()) {
            user = listByCriteria.get(0);
        }
        LogUtils.info("离线查询结果:"+user.toString());

        return user;
    }

    @Override
    public int getTotalCount() {
        return 0;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getUserByUserNamePassword(final User user) {
        User u = getHibernateTemplate().execute(new HibernateCallback<User>() {
            @Override
            public User doInHibernate(Session session) throws HibernateException {
                String hql = "from User where username = ?";
                Query query = session.createQuery(hql);
                query.setParameter(0, user.getUsername());
                User user = (User)query.uniqueResult();
                return user;
            }
        });

        return u;
    }
}
