package com.water.service.impl;

import com.water.dao.CustomerDao;
import com.water.entity.Customer;
import com.water.entity.PageBean;
import com.water.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Water on 17/5/26.
 * Email:water471871679@gmail.com
 */
public class CustomerServiceImpl implements CustomerService{
    @Resource(name = "customerDao")
    private CustomerDao customerDao;


    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    @Override
    public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
        //1.调用DAO查询总记录数
        int totalCount = customerDao.getTotalCount(detachedCriteria);
        //2.创建pageBean对象
        PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
        //3.调用DAO查询分页列表数据
        List<Customer> list = customerDao.getPageList(detachedCriteria, pageBean.getStart(), pageBean.getPageSize());
        //4.列表数据放入pageBean中
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public Customer getById(Long cust_id) {
        return customerDao.getById(cust_id);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
    @Override
    public void save(Customer customer) {
        //维护Customer与字典的的关系,由Struts自动封装参数
        //保存
        customerDao.save(customer);
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
    @Override
    public void saveOrUpdate(Customer customer) {
        customerDao.saveOrUpdate(customer);
    }
}
