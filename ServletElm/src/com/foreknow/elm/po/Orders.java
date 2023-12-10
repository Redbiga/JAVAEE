package com.foreknow.elm.po;

import java.util.List;

public class Orders {
    private int orderId;
    private int businessId;
    private int orderState;
    private int daId;
    private String userId;
    private String orderDate;
    private double orderTotal;
    private Business business;
    List<Orderdetailet> orderdetailets;

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public List<Orderdetailet> getOrderdetailets() {
        return orderdetailets;
    }

    public void setOrderdetailets(List<Orderdetailet> orderdetailets) {
        this.orderdetailets = orderdetailets;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public int getDaId() {
        return daId;
    }

    public void setDaId(int daId) {
        this.daId = daId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }
}
