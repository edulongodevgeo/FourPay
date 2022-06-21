package com.fourcamp.fourpay.enums;

public enum ClientType {
    COMUM(0),
    SUPER(1),
    PREMIUM(2);

    private Integer id;

    ClientType(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
