package com.water.service;

import com.water.entity.PageBean;
import org.hibernate.criterion.DetachedCriteria;

/**
 * Created by Water on 17/5/26.
 * Email:water471871679@gmail.com
 */
public interface CustomerService {

    PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);
}
