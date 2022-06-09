package br.com.foursys.fourpay.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditCard {
	@Id
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

