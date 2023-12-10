package com.foreknow.elm.controller;

import com.foreknow.elm.po.Cart;
import com.foreknow.elm.po.Deliveryaddress;
import com.foreknow.elm.service.CartService;
import com.foreknow.elm.service.DeliveryaddressService;
import com.foreknow.elm.service.impl.CartServiceImpl;
import com.foreknow.elm.service.impl.DeliveryaddressServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

    public class DeliveryAddressController {
    DeliveryaddressService service=new DeliveryaddressServiceImpl();
    public Object listDeliveryAddressByUserId(HttpServletRequest request)throws Exception{
        String userId = request.getParameter("userId");
        List<Deliveryaddress> deliveryaddresses = service.listDeliveryAddressByUserId(userId);
        return deliveryaddresses;
    }

    public Object getDeliveryAddressById(HttpServletRequest request)throws Exception{
        int daId = Integer.parseInt(request.getParameter("daId"));
        Deliveryaddress deliveryAddressById = service.getDeliveryAddressById(daId);
        return deliveryAddressById;
    }
    public Object saveDeliveryAddress(HttpServletRequest request)throws Exception{
        String contactName = request.getParameter("contactName");
        String contactTel = request.getParameter("contactTel");
        String address = request.getParameter("address");
        int contactSex = Integer.parseInt(request.getParameter("contactSex"));
        String userId = request.getParameter("userId");
        int i = service.saveDeliveryAddress(contactName,contactSex,contactTel,address,userId);
        return i;
    }

    public Object updateDeliveryAddress(HttpServletRequest request)throws  Exception{
        String contactName = request.getParameter("contactName");
        String contactTel = request.getParameter("contactTel");
        String address = request.getParameter("address");
        String userId = request.getParameter("userId");
        int contactSex = Integer.parseInt(request.getParameter("contactSex"));
        int daId = Integer.parseInt(request.getParameter("daId"));
        int i = service.updateDeliveryAddress(daId,contactName,contactSex,contactTel,address,userId);
        return i;
    }
    public Object removeDeliveryAddress(HttpServletRequest request)throws  Exception{
        int daId = Integer.parseInt(request.getParameter("daId"));
        int i = service.removeDeliveryAddress(daId);
        return i;
    }
}
