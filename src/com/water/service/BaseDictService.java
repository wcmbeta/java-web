package com.water.service;

import com.water.entity.BaseDict;

import java.util.List;

/**
 * Created by Water on 17/5/27.
 * Email:water471871679@gmail.com
 */
public interface BaseDictService {

    List<BaseDict> getListByTypeCode(String dict_type_code);
}
