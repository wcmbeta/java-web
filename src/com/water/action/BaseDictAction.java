package com.water.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.water.entity.BaseDict;
import com.water.service.BaseDictService;
import org.apache.struts2.ServletActionContext;

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
        String json = new Gson().toJson(list);
        //将Json发送给浏览器
        ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(json);
        return null;//告诉struts不需要对结果进行处理
    }

    public String getDict_type_code() {
        return dict_type_code;
    }

    public void setDict_type_code(String dict_type_code) {
        this.dict_type_code = dict_type_code;
    }

    public BaseDictService getBaseDictService() {
        return baseDictService;
    }

    public void setBaseDictService(BaseDictService baseDictService) {
        this.baseDictService = baseDictService;
    }
}
