package com.fourcamp.fourpay.model;

import javax.persistence.Entity;

@Entity
public class CreditCard extends Card{
    private Double limitCredit;

    public CreditCard() {
    }

    public CreditCard(Double limitCredit) {
        this.limitCredit = limitCredit;
    }

    public Double getLimitCredit() {
        return limitCredit;
    }

    public void setLimitCredit(Double limitCredit) {
        this.limitCredit = limitCredit;
    }
}
