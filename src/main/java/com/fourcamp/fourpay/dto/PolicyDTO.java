package com.fourcamp.fourpay.dto;

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
