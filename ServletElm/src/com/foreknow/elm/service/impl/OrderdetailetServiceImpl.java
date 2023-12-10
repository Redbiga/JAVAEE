package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.OrderdetailetDao;
import com.foreknow.elm.dao.impl.OrderdetailetDaoImpl;
import com.foreknow.elm.po.Orderdetailet;
import com.foreknow.elm.po.Orders;
import com.foreknow.elm.service.OrderdetailetService;
import com.foreknow.elm.service.OrdersService;
import com.foreknow.elm.util.DBUtil;

import java.util.List;

public class OrderdetailetServiceImpl implements OrderdetailetService {
    OrderdetailetDao dao=new OrderdetailetDaoImpl();

    @Override
    public  List<Orderdetailet> getOrdersByorderId(int orderId) {
        List<Orderdetailet> orderdetailet=null;
        try {
            DBUtil.getConnection();
            orderdetailet = dao.getOrdersByorderId(orderId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return orderdetailet;
    }
}
