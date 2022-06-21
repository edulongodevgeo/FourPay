package com.fourcamp.fourpay.enums;

public enum CellPhoneProvider {
    CLARO(0),
    VIVO(1),
    TIM(2),
    OI(3);

    private CellPhoneProvider(Integer id) {
        this.id = id;
    }



    private Integer id;



    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



}
