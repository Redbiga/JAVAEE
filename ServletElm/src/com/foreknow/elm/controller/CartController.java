package com.foreknow.elm.controller;

import com.foreknow.elm.po.Cart;
import com.foreknow.elm.service.CartService;
import com.foreknow.elm.service.impl.CartServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
public class CartController {
    CartService service=new CartServiceImpl();
        public Object listCart(HttpServletRequest request)throws Exception{
        String userId = request.getParameter("userId");
      Integer businessId = Integer.valueOf(request.getParameter("businessId"));
        List<Cart> carts = service.listCart(userId, businessId);
        return carts;
    }

    public Object updateCart(HttpServletRequest request)throws Exception{
        String userId = request.getParameter("userId");
        int businessId = Integer.parseInt(request.getParameter("businessId"));
        int foodId = Integer.parseInt(request.getParameter("foodId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int i = service.updateCart(userId, businessId, foodId,quantity);
        return i;
    }
    public Object removeCart(HttpServletRequest request)throws Exception{
        String userId = request.getParameter("userId");
        int businessId = Integer.parseInt(request.getParameter("businessId"));
        int foodId = Integer.parseInt(request.getParameter("foodId"));
        int i = service.removeCart(userId, businessId, foodId);
        return i;
    }

    public Object removeCart1(HttpServletRequest request)throws Exception{
        String userId = request.getParameter("userId");
        int businessId = Integer.parseInt(request.getParameter("businessId"));
        int i = service.removeCart1(userId, businessId);
        return i;
    }

    public Object saveCart(HttpServletRequest request)throws  Exception{
        String userId = request.getParameter("userId");
        int businessId = Integer.parseInt(request.getParameter("businessId"));
        int foodId = Integer.parseInt(request.getParameter("foodId"));
        int i = service.saveCart(userId, businessId, foodId);
        return i;
    }
}
