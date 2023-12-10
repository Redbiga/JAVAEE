package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.impl.CartDaoImpl;
import com.foreknow.elm.dao.impl.DeliveryaddressDaoImpl;
import com.foreknow.elm.po.Cart;
import com.foreknow.elm.po.Deliveryaddress;
import com.foreknow.elm.service.DeliveryaddressService;
import com.foreknow.elm.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class DeliveryaddressServiceImpl implements DeliveryaddressService {
    DeliveryaddressDaoImpl dao=  new DeliveryaddressDaoImpl();
    @Override
    public List<Deliveryaddress> listDeliveryAddressByUserId(String userId) {
        List<Deliveryaddress> list= new ArrayList<>();
        try {
            DBUtil.getConnection();
            list = dao.listDeliveryAddressByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return list;

    }

    @Override
    public Deliveryaddress getDeliveryAddressById(int daId) {
        Deliveryaddress deliveryaddress=null;
        try {
            DBUtil.getConnection();
           deliveryaddress= dao.getDeliveryAddressById(daId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return deliveryaddress;
    }

    @Override
    public int saveDeliveryAddress(String contactName, int contactSex, String contactTel, String address, String userId) {
        int issave=-1;
        try {
            DBUtil.getConnection();
            issave= dao.saveDeliveryAddress(contactName,contactSex,contactTel,address,userId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return issave;

    }

    @Override
    public int updateDeliveryAddress(int daId, String contactName, int contactSex, String contactTel, String address, String userId) {
        int issave=-1;
        try {
            DBUtil.getConnection();
            issave= dao.updateDeliveryAddress(daId,contactName,contactSex,contactTel,address,userId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return issave;
    }

    @Override
    public int removeDeliveryAddress(int daId) throws Exception {
        int issave=-1;
        try {
            DBUtil.getConnection();
            issave= dao.removeDeliveryAddress(daId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return issave;
    }
}
