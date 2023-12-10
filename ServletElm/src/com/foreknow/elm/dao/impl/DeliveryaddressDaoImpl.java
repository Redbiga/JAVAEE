package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.DeliveryaddressDao;
import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.Cart;
import com.foreknow.elm.po.Deliveryaddress;
import com.foreknow.elm.po.Food;
import com.foreknow.elm.service.impl.BusinessServiceImpl;
import com.foreknow.elm.service.impl.FoodServiceImpl;
import com.foreknow.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryaddressDaoImpl implements DeliveryaddressDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public List<Deliveryaddress> listDeliveryAddressByUserId(String userId) throws Exception {
        List<Deliveryaddress> list=new ArrayList<Deliveryaddress>();
        String sql="SELECT * FROM `deliveryaddress`where userId=?";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1,userId);
            rs = pst.executeQuery();
            while(rs.next()) {
                Deliveryaddress deliveryaddress = new Deliveryaddress();
                deliveryaddress.setDaId(rs.getInt("daId"));
                deliveryaddress.setContactSex(rs.getInt("contactSex"));
                deliveryaddress.setContactName(rs.getString("contactName"));
                deliveryaddress.setContactTel(rs.getString("contactTel"));
                deliveryaddress.setAddress(rs.getString("address"));
                deliveryaddress.setUserId(rs.getString("userId"));
                list.add(deliveryaddress);
            }
        }finally {
            DBUtil.close(rs,pst);
        }
        return list;
    }

    @Override
    public Deliveryaddress getDeliveryAddressById(int daId) throws Exception {
        Deliveryaddress deliveryaddress=null;
        String sql = "SELECT * FROM `deliveryaddress`where daId=?";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1,daId);
            rs = pst.executeQuery();
            while (rs.next()){
                deliveryaddress=new Deliveryaddress();
                deliveryaddress.setDaId(rs.getInt("daId"));
                deliveryaddress.setContactSex(rs.getInt("contactSex"));
                deliveryaddress.setContactName(rs.getString("contactName"));
                deliveryaddress.setContactTel(rs.getString("contactTel"));
                deliveryaddress.setAddress(rs.getString("address"));
                deliveryaddress.setUserId(rs.getString("userId"));

            }

        }finally {
            DBUtil.close(rs,pst);
        }
        return deliveryaddress;
    }

    @Override
        public int saveDeliveryAddress(String contactName, int contactSex, String contactTel, String address, String userId) throws Exception {
        int num=-1;
        String sql = "INSERT INTO deliveryaddress (contactName,contactSex,contactTel,address,userId) VALUES(?,?,?,?,?)";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, contactName);
            pst.setInt(2, contactSex);
            pst.setString(3, contactTel);
            pst.setString(4, address);
            pst.setString(5, userId);
            num = pst.executeUpdate();
        }finally {
            DBUtil.close(rs, pst);
        }
        return num;
    }

    @Override
    public int updateDeliveryAddress(int daId, String contactName, int contactSex, String contactTel, String address, String userId) throws Exception {
        int num=-1;
        String sql = "UPDATE deliveryaddress set contactName=? ,contactSex=? ,contactTel=?,address=?, userId=? where daId=?";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, contactName);
            pst.setInt(2, contactSex);
            pst.setString(3, contactTel);
            pst.setString(4, address);
            pst.setString(5, userId);
            pst.setInt(6, daId);
            num = pst.executeUpdate();
        } finally {
            DBUtil.close(rs, pst);
        }
        return num;
    }

    @Override
    public int removeDeliveryAddress(int daId) throws Exception {
        int num=-1;
        String sql = "delete from deliveryaddress where daId=?";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1,daId);
            num = pst.executeUpdate();
        } finally {
            DBUtil.close(rs, pst);
        }
        return num;
    }
}
