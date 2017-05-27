package com.water.dao.impl;

import com.water.dao.CustomerDao;
import com.water.entity.Customer;

/**
 * Created by Water on 17/5/25.
 * Email:water471871679@gmail.com
 */
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao<Customer> {

//    @Override
//    public void save(Customer customer) {
//    }
//
//    @Override
//    public void delete(Customer customer) {
//
//    }
//
//    @Override
//    public void delete(Serializable id) {
//
//    }
//
//    @Override
//    public void update(Customer customer) {
//
//    }
//
//    @Override
//    public Customer getById(Serializable id) {
//        return null;
//    }
//
//    @Override
//    public Integer getTotalCount(DetachedCriteria dc) {
//        //设置查询的聚合函数,总记录数
//        dc.setProjection(Projections.rowCount());
//        List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
//        //清空之前设置的聚合函数
//        dc.setProjection(null);
//        int count;
//        if (null != list && !list.isEmpty()) {
//            count = list.get(0).intValue();
//            LogUtils.info("总条数"+ count);
//            return count;
//        }
//        return 0;
//    }
//
//    @Override
//    public List<Customer> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
//
//        List<Customer>list = (List<Customer>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
//
//        return list;
//    }
}
