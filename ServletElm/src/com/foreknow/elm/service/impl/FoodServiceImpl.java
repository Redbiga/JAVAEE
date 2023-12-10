package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.BusinessDao;
import com.foreknow.elm.dao.FoodDao;
import com.foreknow.elm.dao.impl.BusinessDaoImpl;
import com.foreknow.elm.dao.impl.FoodDaoImpl;
import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.Food;
import com.foreknow.elm.service.FoodService;
import com.foreknow.elm.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class FoodServiceImpl implements FoodService {

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        List<Food> list  = new ArrayList<>();
        FoodDao dao = new FoodDaoImpl();
        try {
            DBUtil.getConnection();
            list = dao.listFoodByBusinessId(businessId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return list;
    }
    }

