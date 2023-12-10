package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.CartDao;
import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.Cart;
import com.foreknow.elm.po.Food;
import com.foreknow.elm.service.impl.BusinessServiceImpl;
import com.foreknow.elm.service.impl.FoodServiceImpl;
import com.foreknow.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    private Connection con = null;
    private ResultSet rs = null;    private PreparedStatement pst = null;


    @Override
        public List<Cart> listCart(String userId,Integer businessId) throws Exception {
        List<Cart> list=new ArrayList<>();
        BusinessServiceImpl businessService = new BusinessServiceImpl();
        FoodServiceImpl foodService = new FoodServiceImpl();
        BusinessDaoImpl businessDao = new BusinessDaoImpl();
        Business business = null;
        Food food=null;
        String sql="SELECT * FROM `cart`,business where cart.businessId=business.businessId and cart.userId=? and cart.businessId=?";
        String sql1="SELECT * FROM `cart` where  userId=? and businessId=?";
        String sql2="SELECT c.*,f.foodId ffoodId,  f.foodName ffoodName,f.foodExplain ffoodExplain,f.foodImg ffoodImg,f.foodPrice ffoodPrice,f.businessId fbusinessId,f.remarks fremarks,  b.businessId bbusinessId, b.businessName bbusinessName, b.businessAddress bbusinessAddress,b.businessExplain bbusinessExplain,b.businessImg bbusinessImg,b.orderTypeId borderTypeId, b.starPrice bstarPrice,b.deliveryPrice bdeliveryPrice\n" +
                "from cart c,food f, business b\n" +
                "where c.businessId=b.businessId and c.foodId=f.foodId and c.foodId=f.foodId and c.businessId=? and c.userId=?";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql2);
            pst.setString(2,userId);
            pst.setInt(1,businessId);
            rs = pst.executeQuery();
            while(rs.next()) {
                Cart cart = new Cart();
                cart.setCartId(rs.getInt("cartId"));
                cart.setBusinessId(rs.getInt("businessId"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setUserId(rs.getString("userId"));
                cart.setFoodId(rs.getInt("foodId"));
                Food f = new Food();
                f.setFoodId(rs.getInt("ffoodId"));
                f.setFoodName(rs.getString("ffoodName"));
                f.setFoodExplain(rs.getString("ffoodExplain"));
                f.setFoodImg(rs.getString("ffoodImg"));
                f.setFoodPrice(rs.getDouble("ffoodPrice"));
                f.setBusinessId(rs.getInt("fbusinessId"));
                f.setRemarks(rs.getString("fremarks"));
                cart.setFood(f);
                Business b = new Business();
                b.setBusinessId(rs.getInt("bbusinessId"));
                b.setBusinessName(rs.getString("bbusinessName"));
                b.setBusinessAddress(rs.getString("bbusinessAddress"));
                b.setBusinessExplain(rs.getString("bbusinessExplain"));
                b.setBusinessImg(rs.getString("bbusinessImg"));
                b.setOrderTypeId(rs.getInt("borderTypeId"));
                b.setStarPrice(rs.getDouble("bstarPrice"));
                b.setDeliveryPrice(rs.getDouble("bdeliveryPrice"));
                cart.setBusiness(b);
                list.add(cart);
            }
        }finally {
            DBUtil.close(rs,pst);
        }
        return list;
    }

    @Override
    public int saveCart(String userId, Integer businessId, int foodId) throws Exception {
        int num;
            String sql = "INSERT INTO cart (userId,businessId,foodId,quantity) VALUES(?,?,?,1)";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            pst.setInt(2, businessId);
            pst.setInt(3, foodId);
            num = pst.executeUpdate();
        } finally {
            DBUtil.close(rs, pst);
        }
        return num;
    }

    @Override
    public int updateCart(String userId, Integer businessId, int foodId, int quantity) throws Exception {
        int num;
        String sql = "UPDATE cart set quantity=? where userId=? and businessId=? and foodId=?";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, quantity);
            pst.setString(2, userId);
            pst.setInt(3, businessId);
            pst.setInt(4, foodId);
            num = pst.executeUpdate();
        } finally {
            DBUtil.close(rs, pst);
        }
        return num;
    }

    @Override
    public int removeCart(String userId, Integer businessId, int foodId) throws Exception {
        int num;
        String sql = "delete from cart where userId=? and businessId=? and foodId=?";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1,userId);
            pst.setInt(2,businessId);
            pst.setInt(3,foodId);
            num = pst.executeUpdate();
        } finally {
            DBUtil.close(rs, pst);
        }
        return num;
    }

    @Override
    public int removeCart1(String userId, Integer businessId) throws Exception {
        int num;
        String sql = "delete from cart where userId=? and businessId=?";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1,userId);
            pst.setInt(2,businessId);
            num = pst.executeUpdate();
        } finally {
            DBUtil.close(rs, pst);
        }
        return num;
    }
}
