package com.foreknow.elm.dao;

import com.foreknow.elm.po.Business;

import java.util.List;

public interface BusinessDao {
    /**
     * 根据分类的编号查询商家信息
     * @param orderTypeId 分类的编号
     * @return List集合
     * @throws Exception
     */
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) throws Exception;

    /**
     * 根据商家的编号查询商家的信息
     * @param businessId
     * @return Business对象
     * @throws Exception
     */
    public Business getBusinessById(Integer businessId)throws Exception;
  }
