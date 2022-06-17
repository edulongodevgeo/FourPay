package br.com.foursys.fourpay.dto;

import br.com.foursys.fourpay.model.CreditCard;
import br.com.foursys.fourpay.model.Insurance;

import javax.persistence.*;
import java.util.UUID;

public class PolicyDTO {
	
    private String creditCard;

    private Integer insurance;

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public Integer getInsurance() {
        return insurance;
    }

    public void setInsurance(Integer insurance) {
        this.insurance = insurance;
    }


}
