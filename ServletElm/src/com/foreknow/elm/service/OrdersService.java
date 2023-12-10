package com.foreknow.elm.service;

import com.foreknow.elm.po.Orders;

import java.util.List;

public interface OrdersService {
    /**
     * 根据用户编号、商家编号、订单总金额、送货地址编号向订单表中添加一条记录，
     *    ​           并获取自动生成的订单编号，
     *    ​           然后根据用户编号、商家编号从购物车表中查询所有数据，批量添加到订单明细表中，
     *    ​           然后根据用户编号、商家编号删除购物车表中的数据。
     * @param userId
     * @param businessId
     * @param daId
     * @return
     */
    public  int createOrders(String userId,int businessId,int daId );

    /**
     * 功能：根据订单编号查询订单信息，包括所属商家信息，和此订单的所有订单明细信息
     * @param orderId
     * @return
     */
    public Orders getOrdersById(int orderId);

    /**
     * 功能：根据用户编号查询此用户的所有订单信息
     * @param userId
     * @return
     */
    public List<Orders> listOrdersByUserId(String userId);
}
