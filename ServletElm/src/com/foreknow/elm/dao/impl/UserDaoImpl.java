package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.UserDao;
import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.Food;
import com.foreknow.elm.po.User;
import com.foreknow.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public User getUserByIdByPass(String userId, String password) throws Exception {
        User user = null;
        String sql = "SELECT * FROM `user` WHERE userId=? and password=?";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            pst.setString(2, password);
            rs = pst.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUserId(rs.getString("userId"));
                user.setPassword(rs.getString("password"));
                user.setUserName(rs.getString("userName"));
                user.setUserImg(rs.getString("userImg"));
                user.setUserSex(rs.getInt("userSex"));
                user.setDelTag(rs.getInt("delTag"));
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return user;
    }

    @Override
    public int getUserById(String userId) throws Exception {
        int index = 0;
        User user=null;
        String sql = "SELECT * FROM `user` WHERE userId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, userId);
            rs=pst.executeQuery();
            while (rs.next()) {
                 user = new User();
                user.setId(rs.getInt("id"));
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return user.getId();
    }

    @Override
    public int saveUser(String userId, String password, String userName, int userSex) throws Exception {
        int num;
        String sql = "INSERT INTO user (userId,password,userName,userSex) VALUES(?,?,?,?)";
        try {
            //获取连接
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            pst.setString(2, password);
            pst.setString(3, userName);
            pst.setInt(4, userSex);
            num = pst.executeUpdate();
        } finally {
            DBUtil.close(rs, pst);
        }
        return num;
    }
}
