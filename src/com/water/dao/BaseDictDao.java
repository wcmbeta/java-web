package com.water.dao;

import com.water.entity.BaseDict;

import java.util.List;

/**
 * Created by Water on 17/5/31.
 * Email:water471871679@gmail.com
 */
public interface BaseDictDao {
    /**
     * 根据类型获取数据字典列表
     */
    List<BaseDict> getListByTypeCode(String dict_type_code);
}
