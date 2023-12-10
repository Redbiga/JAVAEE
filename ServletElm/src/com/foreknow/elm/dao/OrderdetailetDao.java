package com.foreknow.elm.dao;

import com.foreknow.elm.po.Orderdetailet;
import com.foreknow.elm.po.Orders;

import java.util.List;

public interface OrderdetailetDao {
    /**
     * 功能：添加订单明细
     * @param foodId
     * @param orderId
     * @return
     * @throws Exception
     */
    public int saveOrderdetailet(int foodId,int orderId,int quantity)throws Exception;

    /**
     * 根据订单编号查询订单明细信息
     * @param orderId
     * @return
     * @throws Exception
     */
    public List<Orderdetailet> getOrdersByorderId(int orderId)throws Exception;

}
