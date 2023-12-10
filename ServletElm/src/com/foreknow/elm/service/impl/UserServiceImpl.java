package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.UserDao;
import com.foreknow.elm.dao.impl.UserDaoImpl;
import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.User;
import com.foreknow.elm.service.UserService;
import com.foreknow.elm.util.DBUtil;

import java.util.List;


public class UserServiceImpl implements UserService {

    @Override
    public User getUserByIdByPass(String userId, String password) {
        User user=null ;
        UserDao dao= new UserDaoImpl();
        try {
            DBUtil.getConnection();
          user = dao.getUserByIdByPass(userId, password);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return user;
    }

    @Override
    public int getUserById(String userId) {
        int index=-1;
        UserDao dao=new UserDaoImpl();
        try {
            DBUtil.getConnection();
            index=dao.getUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return index;
    }

    @Override
    public int saveUser(String userId, String password, String userName, int userSex) {
        int issave=-1;
        UserDao dao=new UserDaoImpl();
        try {
            DBUtil.getConnection();
            issave=dao.saveUser(userId,password,userName,userSex);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return issave;
    }
}
