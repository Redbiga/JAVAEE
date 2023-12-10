package com.foreknow.elm.dao;

import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.Food;

import java.util.List;

public interface FoodDao {
    /**
     * 功能：根据商家编号查询所属食品信息
     * @param businessId 分类的编号
     * @return List集合
     * @throws Exception
     */
    public List<Food> listFoodByBusinessId(Integer businessId) throws Exception;
}
