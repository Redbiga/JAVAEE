package com.foreknow.elm.controller;

import com.foreknow.elm.po.Business;
import com.foreknow.elm.service.BusinessService;
import com.foreknow.elm.service.impl.BusinessServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BusinessController {
  /**
   * 根据orderTypeId查询商家的信息
   * @param request
   * @return Object(list extends Object)
   * @throws Exception
   */
  public Object listBusinessByOrderTypeId(HttpServletRequest request)throws Exception{
    //获取请求参数 BusinessController/listBusinessByOrderTypeId?orderTypeId=1
    Integer orderTypeId = Integer.valueOf(request.getParameter("orderTypeId"));
    //调用service的方法
    BusinessService service = new BusinessServiceImpl();
    List<Business> list = service.listBusinessByTypeId(orderTypeId);
    return list;
  }

  /**
   * 根据businessId查询某一个商家的信息
   * @param request
   * @return Business对象
   * @throws Exception
   */
  public Object getBusinessById(HttpServletRequest request)throws Exception{
    int businessId = Integer.parseInt(request.getParameter("businessId"));
    BusinessService service = new BusinessServiceImpl();
    Business business = service.getBusinessById(businessId);
    return business;
  }


}
