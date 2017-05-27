package com.water.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.water.entity.Customer;
import com.water.entity.PageBean;
import com.water.service.CustomerService;
import com.water.utils.LogUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Water on 17/5/26.
 * Email:water471871679@gmail.com
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();
    private CustomerService customerService;
    private Integer currentPage;
    private Integer pageSize;
    public String list()throws Exception{
        LogUtils.info("CustomerAction.list()");
        LogUtils.info(customer.getCust_name() + "-" + customer.getCust_id());

        //封装离线查询
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        if (StringUtils.isNotBlank(customer.getCust_name())) {
            detachedCriteria.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
        }

        //1 直接查询service分页数据
        PageBean pageBean = customerService.getPageBean(detachedCriteria, currentPage, pageSize);
        LogUtils.info("数据条数:"+pageBean.getList().size());
        //2 将pageBean放入request域,转发到列表页
        ActionContext.getContext().put("pageBean",pageBean);
        return "list";
    }


    @Override
    public Customer getModel() {
        return customer;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
