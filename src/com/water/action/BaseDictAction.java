package com.water.action;

import com.opensymphony.xwork2.ActionSupport;
import com.water.entity.BaseDict;
import com.water.service.BaseDictService;

import java.util.List;

/**
 * Created by Water on 17/5/27.
 * Email:water471871679@gmail.com
 */
public class BaseDictAction extends ActionSupport {
    private String dict_type_code;
    private BaseDictService baseDictService;
    @Override
    public String execute() throws Exception {
        //获取数据字典
        List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
        //转为jason

        return super.execute();
    }
}
