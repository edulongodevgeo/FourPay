package com.fourcamp.fourpay.model;

import javax.persistence.Entity;

@Entity
public class DebitCard extends Card{
    private Double transactionLimit;

    public DebitCard() {
    }

    public DebitCard(Double transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public Double getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(Double transactionLimit) {
        this.transactionLimit = transactionLimit;
    }
}
