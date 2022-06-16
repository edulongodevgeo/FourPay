package br.com.foursys.fourpay.dto;

import br.com.foursys.fourpay.enums.PixKeyType;

public class PixTransferDTO {
    private Double value;
    private PixKeyType keyType;
    private String keyValue;
    private Integer payerId;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public PixKeyType getKeyType() {
        return keyType;
    }

    public void setKeyType(PixKeyType keyType) {
        this.keyType = keyType;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public Integer getPayerId() {
        return payerId;
    }

    public void setPayerId(Integer payerId) {
        this.payerId = payerId;
    }
}
