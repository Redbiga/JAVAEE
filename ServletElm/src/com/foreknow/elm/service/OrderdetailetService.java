package com.foreknow.elm.service;

import com.foreknow.elm.po.Orderdetailet;

import java.util.List;

public interface OrderdetailetService {

    /**
     * 根据订单编号查询订单明细信息
     * @param orderId
     * @return
     * @throws Exception
     */
    public List<Orderdetailet> getOrdersByorderId(int orderId);

}
