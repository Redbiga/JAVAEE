package com.foreknow.elm.controller;

import com.foreknow.elm.po.Deliveryaddress;
import com.foreknow.elm.po.Orders;
import com.foreknow.elm.service.OrdersService;
import com.foreknow.elm.service.impl.OrdersServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OrdersController {
    OrdersService service=new OrdersServiceImpl();
    public Object listOrdersByUserId(HttpServletRequest request)throws Exception{
        String userId = request.getParameter("userId");
        List<Orders> orders = service.listOrdersByUserId(userId);
        return orders;
    }

    public Object getOrdersById(HttpServletRequest request)throws Exception{
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Orders orders = service.getOrdersById(orderId);
        return orders;
    }
    public Object createOrders(HttpServletRequest request)throws Exception{
        String userId = request.getParameter("userId");
        int businessId = Integer.parseInt(request.getParameter("businessId"));
        int daId = Integer.parseInt(request.getParameter("daId"));
        int orders = service.createOrders(userId, businessId, daId);
        return orders;
    }

}
