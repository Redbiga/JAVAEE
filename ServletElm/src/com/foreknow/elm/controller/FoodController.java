package com.foreknow.elm.controller;

import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.Food;
import com.foreknow.elm.service.BusinessService;
import com.foreknow.elm.service.FoodService;
import com.foreknow.elm.service.impl.BusinessServiceImpl;
import com.foreknow.elm.service.impl.FoodServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FoodController {
    public Object listFoodByBusinessId(HttpServletRequest request)throws Exception{
        //获取请求参数 BusinessController/listBusinessByOrderTypeId?orderTypeId=1
        Integer businessId = Integer.valueOf(request.getParameter("businessId"));
        //调用service的方法
        FoodService service = new FoodServiceImpl();
        List<Food> list = service.listFoodByBusinessId(businessId);
        return list;
    }
}
