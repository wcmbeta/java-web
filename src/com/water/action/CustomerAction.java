package com.water.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.water.entity.Customer;
import com.water.entity.PageBean;
import com.water.service.CustomerService;
import com.water.utils.LogUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.File;

/**
 * Created by Water on 17/5/26.
 * Email:water471871679@gmail.com
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();
    private CustomerService customerService;
    private Integer currentPage;
    private Integer pageSize;

    //文件上传
    private File photo; //上传的文件会自动封装到file对象
    private String photoFileName;
    private String photoContentType;
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

    public String add ()throws Exception{
        LogUtils.info("customer.add()");
        //保存图片
        if (null!=photo) {
            LogUtils.info("文件名称:" + photoFileName);
            LogUtils.info("文件类型:" + photoContentType);
            String root = ServletActionContext.getServletContext().getRealPath("/upload");
//            File basePath = new File(ServletActionContext.getServletContext().getRealPath("/upload"));
//            LogUtils.info("保存路径:"+root +"/114.png");
            photo.renameTo(new File(root + "/"+photoFileName));
//            FileUtils.copyFile(photo,new File(basePath.getCanonicalPath()+"/" + photoFileName));
        }

        //1调用service保存
        LogUtils.info("customer:"+customer.toString());
        customerService.saveOrUpdate(customer);
        //2重定向
        return "toList";
    }
    public String saveOrUpdate()throws Exception{
        LogUtils.info("customer.saveOrUpdate()");
        //保存图片
        if (null!=photo) {
            LogUtils.info("文件名称:" + photoFileName);
            LogUtils.info("文件类型:" + photoContentType);
            String root = ServletActionContext.getServletContext().getRealPath("/upload");
//            File basePath = new File(ServletActionContext.getServletContext().getRealPath("/upload"));
//            LogUtils.info("保存路径:"+root +"/114.png");
            photo.renameTo(new File(root + "/"+photoFileName));
//            FileUtils.copyFile(photo,new File(basePath.getCanonicalPath()+"/" + photoFileName));
        }

        //1调用service保存
        LogUtils.info("customer:"+customer.toString());
        customerService.saveOrUpdate(customer);
        return "toList";
    }

    public String save()throws Exception{

        Customer customer = new Customer();
        customer.setCust_name("测试保存");
        customerService.save(customer);
        return "list";
    }

    public String edit()throws Exception{
        LogUtils.info("toEdit");
        Customer c = customerService.getById(customer.getCust_id());
        ActionContext.getContext().put("customer",c);
        return "edit";
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

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }
}
