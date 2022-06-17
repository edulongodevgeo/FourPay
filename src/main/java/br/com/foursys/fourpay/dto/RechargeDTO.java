package br.com.foursys.fourpay.dto;

import br.com.foursys.fourpay.enums.CellPhoneProvider;
import br.com.foursys.fourpay.enums.TransactionType;

public class RechargeDTO {
    private String cellphoneNumber;
    private CellPhoneProvider cellphoneProvider;
    private Double value;
    private TransactionType paymentMethod;

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public CellPhoneProvider getCellphoneProvider() {
        return cellphoneProvider;
    }

    public void setCellphoneProvider(CellPhoneProvider cellphoneProvider) {
        this.cellphoneProvider = cellphoneProvider;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public TransactionType getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(TransactionType paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
