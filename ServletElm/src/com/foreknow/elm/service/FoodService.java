package com.foreknow.elm.service;

import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.Food;

import java.util.List;

public interface FoodService {
    /**
     * 根据orderTypeId查询商家信息
     * @param businessId 类型编号
     * @return List集合
     */
    public List<Food> listFoodByBusinessId(Integer businessId);

}
