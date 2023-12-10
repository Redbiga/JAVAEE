package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.FoodDao;
import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.Food;
import com.foreknow.elm.util.DBUtil;
//import com.sun.org.apache.regexp.internal.RE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) throws Exception {

        List<Food> list = new ArrayList<>();
        String sql = "select * from food where businessId=? order by businessId";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1,businessId);
            rs = pst.executeQuery();
            while(rs.next()) {
                Food food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodImg(rs.getString("foodImg"));
                food.setRemarks(rs.getString("remarks"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                list.add(food);///
            }

        }finally {
            DBUtil.close(rs,pst);
        }
        return list;
    }
}
