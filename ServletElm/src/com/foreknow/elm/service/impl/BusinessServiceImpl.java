package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.BusinessDao;
import com.foreknow.elm.dao.impl.BusinessDaoImpl;
import com.foreknow.elm.po.Business;
import com.foreknow.elm.service.BusinessService;
import com.foreknow.elm.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessServiceImpl implements BusinessService {
    @Override
    public List<Business> listBusinessByTypeId(Integer orderTypeId) {
        List<Business> list = new ArrayList<>();
        BusinessDao dao = new BusinessDaoImpl();
        try {
            DBUtil.getConnection();
            list = dao.listBusinessByOrderTypeId(orderTypeId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return list;
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        Business business = null;
        BusinessDao dao = new BusinessDaoImpl();
        try {
            DBUtil.getConnection();
            business = dao.getBusinessById(businessId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return business;
    }
}
