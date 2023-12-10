package com.foreknow.elm.po;

public class Deliveryaddress {
    private int daId;
    private int contactSex;
    private String contactName;
    private String contactTel;
    private String address;
    private String userId;

    public int getDaId() {
        return daId;
    }

    public void setDaId(int daId) {
        this.daId = daId;
    }

    public int getContactSex() {
        return contactSex;
    }

    public void setContactSex(int contactSex) {
        this.contactSex = contactSex;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
