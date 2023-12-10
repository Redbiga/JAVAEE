package com.foreknow.elm.dao;

import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.Deliveryaddress;

import java.util.List;

public interface DeliveryaddressDao {
    /**
     * 功能：根据用户编号查询所属送货地址
     * @param userId
     * @return
     * @throws Exception
     */
    public List<Deliveryaddress> listDeliveryAddressByUserId(String userId) throws Exception;

    /**
     * 功能：根据送货地址编号查询送货地址
     * @param daId
     * @return
     * @throws Exception
     */
    public Deliveryaddress getDeliveryAddressById(int daId)throws Exception;

    /**
     * 功能：向送货地址表中添加一条记录
     * @param contactName
     * @param contactSex
     * @param contactTel
     * @param address
     * @param userId
     * @return
     * @throws Exception
     */
    public int saveDeliveryAddress(String contactName,int contactSex,String contactTel,String address,String userId)throws Exception;

    /**
     * 功能：根据送货地址编号更新送货地址信息
     * @param daId
     * @param contactName
     * @param contactSex
     * @param contactTel
     * @param address
     * @param userId
     * @return
     * @throws Exception
     */
    public int updateDeliveryAddress(int daId,String contactName,int contactSex,String contactTel,String address,String userId)throws Exception;

    /**
     *功能：根据送货地址编号删除一条记录
     * @param daId
     * @return
     * @throws Exception
     */
    public int removeDeliveryAddress(int daId)throws  Exception;
}
