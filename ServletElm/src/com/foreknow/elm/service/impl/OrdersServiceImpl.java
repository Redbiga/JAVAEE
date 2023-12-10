package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.OrdersDao;
import com.foreknow.elm.dao.impl.*;
import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.Cart;
import com.foreknow.elm.po.Deliveryaddress;
import com.foreknow.elm.po.Orders;
import com.foreknow.elm.service.OrdersService;
import com.foreknow.elm.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class OrdersServiceImpl implements OrdersService {
    OrdersDao dao = new OrdersDaoImpl();

    @Override
    public int createOrders(String userId, int businessId, int daId) {
        double orderTotal = 0;
        int orderId = -1;
        try {
            DBUtil.beginTransaction();
            //1、查询当前用户购物车中当前商家的所有食品
            CartDaoImpl cartDao = new CartDaoImpl();
            List<Cart> carts = cartDao.listCart(userId, businessId);
            //2、查询商家信息（需要使用商家的配送费信息）
            BusinessDaoImpl businessDao = new BusinessDaoImpl();
            Business business = businessDao.getBusinessById(businessId);
            //3、获取订单总额
            for (Cart cart : carts) {
                orderTotal += cart.getFood().getFoodPrice() * cart.getQuantity();
            }
            //加上配送费
            orderTotal += business.getDeliveryPrice();
            //3、创建订单，并获取订单编号
            OrdersDaoImpl ordersDao = new OrdersDaoImpl();
            orderId = ordersDao.createOrders(userId, businessId, daId, orderTotal);
            //4、处理相关数据：获取订单明细集合
            OrderdetailetDaoImpl orderdetailetDao = new OrderdetailetDaoImpl();
            //5、批量添加订单明细
            for (Cart cart : carts) {
                orderdetailetDao.saveOrderdetailet(cart.getFoodId(), orderId, cart.getQuantity());
            }
            //6、清空当前用户购物车中当前商家的所有食品
            cartDao.removeCart1(userId, businessId);
            //提交事务
            DBUtil.commitTransaction();
        } catch (Exception e) {
            orderId = 0;
            try {
                DBUtil.rollbackTransaction();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // 关闭Connection
            DBUtil.close();
        }
        return orderId;
    }


    @Override
    public Orders getOrdersById(int orderId) {
        Orders orders = new Orders();
        try {
            DBUtil.getConnection();
            orders = dao.getOrdersById(orderId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return orders;
    }

    @Override
    public List<Orders> listOrdersByUserId(String userId) {
        List<Orders> list = new ArrayList<>();
        try {
            DBUtil.getConnection();
            list = dao.listOrdersByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return list;
    }
}
