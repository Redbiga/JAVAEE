package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.OrderdetailetDao;
import com.foreknow.elm.po.Deliveryaddress;
import com.foreknow.elm.po.Food;
import com.foreknow.elm.po.Orderdetailet;
import com.foreknow.elm.po.Orders;
import com.foreknow.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderdetailetDaoImpl implements OrderdetailetDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public int saveOrderdetailet(int foodId, int orderId, int quantity) throws Exception {
        int num=-1;
        String sql = "INSERT INTO orderdetailet (foodId,orderId,quantity) VALUES(?,?,?)";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, foodId);
            pst.setInt(2, orderId);
            pst.setInt(3, quantity);
            num = pst.executeUpdate();
        }  finally {
            DBUtil.close(rs, pst);
        }
        return num;
    }

    @Override
    public List<Orderdetailet> getOrdersByorderId(int orderId) throws Exception {
        List<Orderdetailet> list=null;
        String sql = "SELECT o.*, f.foodId ffoodId,f.foodName ffoodName,f.foodPrice ffoodPrice FROM orderdetailet o,food f where o.foodId=f.foodId and orderId=?";
        try {
            Orderdetailet od = new Orderdetailet();
            od.setOdId(rs.getInt("odId"));
            od.setOrderId(rs.getInt("orderId"));
            od.setFoodId(rs.getInt("foodId"));
            od.setQuantity(rs.getInt("quantity"));
            Food food = new Food();
            food.setFoodId(rs.getInt("ffoodId"));
            food.setFoodName(rs.getString("ffoodName"));
            food.setFoodPrice(rs.getDouble("ffoodPrice"));
            od.setFood(food);
            list.add(od);
        }finally {
            DBUtil.close(rs,pst);
        }
        return list;
    }
}
