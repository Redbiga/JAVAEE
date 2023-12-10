package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.OrdersDao;
import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.Orders;
import com.foreknow.elm.service.impl.BusinessServiceImpl;
import com.foreknow.elm.util.CommonUtil;
import com.foreknow.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrdersDaoImpl implements OrdersDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;


    @Override
    public int createOrders(String userId, int businessId, int daId, double orderTotal) throws Exception{
        int orderId = 0;
        String sql = "INSERT INTO orders  VALUES(null,?,?,?,?,?,0)";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, userId);
            pst.setInt(2, businessId);
            pst.setString(3, CommonUtil.getCurrentDate());
            pst.setDouble(4, orderTotal);
            pst.setInt(5, daId);

            //添加到订单明细表
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if (rs.next()) {//用while一样么
                orderId = rs.getInt(1);//啥意思！！
            }
        }  finally {
            DBUtil.close(rs, pst);
        }
        return orderId;
    }

    @Override
    public Orders getOrdersById(int orderId)throws Exception {
        Orders orders = null;
        BusinessServiceImpl businessService = new BusinessServiceImpl();
        String sql = "SELECT o.*,b.businessId bbusinessId,b.businessName bbusinessName, b.deliveryPrice bdeliveryPrice FROM orders o,business b where o.businessId=b.businessId and orderId=?";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, orderId);
            rs = pst.executeQuery();
            while (rs.next()) {
                orders = new Orders();
                orders.setOrderId(rs.getInt("orderId"));
                orders.setUserId(rs.getString("userId"));
                orders.setBusinessId(rs.getInt("businessId"));
                orders.setOrderDate(rs.getString("orderDate"));
                orders.setOrderTotal(rs.getDouble("orderTotal"));
                orders.setOrderState(rs.getInt("orderState"));
                Business business = new Business();
                business.setBusinessId(rs.getInt("bbusinessId"));
                business.setBusinessName(rs.getString("bbusinessName"));
                business.setDeliveryPrice(rs.getDouble("bdeliveryPrice"));
                orders.setBusiness(business);
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return orders;
    }

    @Override
    public List<Orders> listOrdersByUserId(String userId)throws Exception {
        List<Orders> list = new ArrayList<Orders>();
        String sql = "SELECT o.*,b.businessId bbusinessId,b.businessName bbusinessName, b.deliveryPrice bdeliveryPrice FROM orders o,business b where o.businessId=b.businessId and userId=?";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Orders orders = new Orders();
                orders.setOrderId(rs.getInt("orderId"));
                orders.setUserId(rs.getString("userId"));
                orders.setBusinessId(rs.getInt("businessId"));
                orders.setOrderDate(rs.getString("orderDate"));
                orders.setOrderTotal(rs.getDouble("orderTotal"));
                orders.setOrderState(rs.getInt("orderState"));
                Business business = new Business();
                business.setBusinessId(rs.getInt("bbusinessId"));
                business.setBusinessName(rs.getString("bbusinessName"));
                business.setDeliveryPrice(rs.getDouble("bdeliveryPrice"));
                orders.setBusiness(business);
                list.add(orders);
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return list;
    }
}
