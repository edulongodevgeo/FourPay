package br.com.foursys.fourpay.model;

import br.com.foursys.fourpay.enums.CellPhoneProvider;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recharge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String cellphoneNumber;
    private CellPhoneProvider cellphoneProvider;
    private Double value;
    private String paymentMethod;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
