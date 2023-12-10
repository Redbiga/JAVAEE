package com.foreknow.elm.po;

public class Business {
  //商家编号
  private Integer businessId;
  //商家名称
  private String businessName;
  //商家地址
  private String businessAddress;
  //商家介绍
  private String businessExplain;
  //商家图片（base64）
  private String businessImg;
  //点餐分类
  private Integer orderTypeId;
  //起送费
  private Double starPrice;
  //配送费
  private Double deliveryPrice;
  //备注
  private String remarks;

  public Business() {
  }

  public Business(Integer businessId, String businessName, String businessAddress, String businessExplain, String businessImg, Integer orderTypeId, Double starPrice, Double deliveryPrice, String remarks) {
    this.businessId = businessId;
    this.businessName = businessName;
    this.businessAddress = businessAddress;
    this.businessExplain = businessExplain;
    this.businessImg = businessImg;
    this.orderTypeId = orderTypeId;
    this.starPrice = starPrice;
    this.deliveryPrice = deliveryPrice;
    this.remarks = remarks;
  }

  public Integer getBusinessId() {
    return businessId;
  }

  public void setBusinessId(Integer businessId) {
    this.businessId = businessId;
  }

  public String getBusinessName() {
    return businessName;
  }

  public void setBusinessName(String businessName) {
    this.businessName = businessName;
  }

  public String getBusinessAddress() {
    return businessAddress;
  }

  public void setBusinessAddress(String businessAddress) {
    this.businessAddress = businessAddress;
  }

  public String getBusinessExplain() {
    return businessExplain;
  }

  public void setBusinessExplain(String businessExplain) {
    this.businessExplain = businessExplain;
  }

  public String getBusinessImg() {
    return businessImg;
  }

  public void setBusinessImg(String businessImg) {
    this.businessImg = businessImg;
  }

  public Integer getOrderTypeId() {
    return orderTypeId;
  }

  public void setOrderTypeId(Integer orderTypeId) {
    this.orderTypeId = orderTypeId;
  }

  public Double getStarPrice() {
    return starPrice;
  }

  public void setStarPrice(Double starPrice) {
    this.starPrice = starPrice;
  }

  public Double getDeliveryPrice() {
    return deliveryPrice;
  }

  public void setDeliveryPrice(Double deliveryPrice) {
    this.deliveryPrice = deliveryPrice;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }
}
