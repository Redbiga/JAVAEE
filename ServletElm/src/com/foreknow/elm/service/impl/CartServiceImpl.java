package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.UserDao;
import com.foreknow.elm.dao.impl.CartDaoImpl;
import com.foreknow.elm.dao.impl.UserDaoImpl;
import com.foreknow.elm.po.Cart;
import com.foreknow.elm.service.CartService;
import com.foreknow.elm.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {
    CartDaoImpl dao = new CartDaoImpl();
    @Override
    public List<Cart> listCart(String userId, Integer businessId) {
        List<Cart> list = new ArrayList<>();
        try {
            DBUtil.getConnection();

            list = dao.listCart(userId,businessId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return list;

    }

    @Override
    public int saveCart(String userId, Integer businessId, int foodId) {
        int issave=-1;
        try {
            DBUtil.getConnection();
            issave=dao.saveCart(userId,businessId,foodId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return issave;
    }

    @Override
    public int updateCart(String userId, Integer businessId, int foodId, int quantity) {
        int issave=-1;
        try {
            DBUtil.getConnection();
            issave=dao.updateCart(userId,businessId,foodId,quantity);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return issave;
    }

    @Override
    public int removeCart(String userId, Integer businessId, int foodId) {
        int issave=-1;
        try {
            DBUtil.getConnection();
            issave=dao.removeCart(userId,businessId,foodId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return issave;
    }

    @Override
    public int removeCart1(String userId, Integer businessId) {
        int issave=-1;
        try {
            DBUtil.getConnection();
            issave=dao.removeCart1(userId,businessId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return issave;
    }
}
