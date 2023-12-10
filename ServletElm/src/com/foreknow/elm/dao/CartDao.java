package com.foreknow.elm.dao;

import com.foreknow.elm.po.Cart;

import java.util.List;

public interface CartDao {
    /**
     * 根据用户编号和商家编号查询此用户所有购物车信息
     * @param userId,Integer businessId
     * @return
     * @throws Exception
     */
        public List<Cart> listCart( String userId,Integer businessId)throws Exception;

    /**
     * 功能：向购物车表中添加一条记录
     * @param userId
     * @param businessId
     * @param foodId
     * @return
     * @throws Exception
     */
    public int saveCart(String userId, Integer businessId, int foodId) throws Exception;

    /**
     * 功能：根据用户编号、商家编号、食品编号更新数量
     * @param userId
     * @param businessId
     * @param foodId
     * @param quantity
     * @return
     * @throws Exception
     */
        public int updateCart(String userId,Integer businessId,int foodId,int quantity)throws Exception;

    /**
     * 功能：根据用户编号、商家编号、食品编号删除购物车表中的一条食品记录
     * @param userId
     * @param businessId
     * @param foodId
     * @return
     * @throws Exception
     */
        public int removeCart(String userId,Integer businessId,int foodId)throws  Exception;

    /**
     * 根据用户编号、商家编号删除购物车表中的多条条记录
     * @param userId
     * @param businessId
     * @return
     * @throws Exception
     */
        public int removeCart1(String userId,Integer businessId)throws  Exception;
}
