package com.water.dao.impl;

import com.water.dao.BaseDictDao;
import com.water.entity.BaseDict;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Water on 17/5/31.
 * Email:water471871679@gmail.com
 */
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {
    @Override
    public List<BaseDict> getListByTypeCode(String dict_type_code) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BaseDict.class);
        //查询条件
        detachedCriteria.add(Restrictions.eq("dict_type_code", dict_type_code));
        List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(detachedCriteria);
        return list;
    }
}
