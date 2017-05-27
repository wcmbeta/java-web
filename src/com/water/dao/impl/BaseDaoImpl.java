package com.water.dao.impl;

import com.water.dao.BaseDao;
import com.water.utils.LogUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Water on 17/5/25.
 * Email:water471871679@gmail.com
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    private Class clazz;

    public BaseDaoImpl() {
//        this.clazz = clazz
        //获取泛型父类
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获取运行时的泛型
        this.clazz = (Class) type.getActualTypeArguments()[0];
    }

    @Override
    public void save(T t) {
        getHibernateTemplate().save(t);
    }

    @Override
    public void delete(T t) {
        getHibernateTemplate().delete(t);
    }

    @Override
    public void delete(Serializable id) {
        T t = this.getById(id);
        delete(t);
//        getHibernateTemplate().delete(t);
    }

    @Override
    public void update(T t) {
        getHibernateTemplate().update(t);
    }

    @Override
    public T getById(Serializable id) {
        T t = (T) getHibernateTemplate().get(clazz, id);
        return t;
    }

    @Override
    public Integer getTotalCount(DetachedCriteria dc) {
        //设置查询的聚合函数,总记录数
        dc.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
        //清空之前设置的聚合函数
        dc.setProjection(null);
        int count;
        if (null != list && !list.isEmpty()) {
            count = list.get(0).intValue();
            LogUtils.info("总条数" + count);
            return count;
        } else {
            return null;

        }
    }
        @Override
        public List<T> getPageList (DetachedCriteria dc, Integer start, Integer pageSize){
            List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);

            return list;
        }
    }
