package com.fourcamp.fourpay.model;


import javax.persistence.Entity;


@Entity
public class SavingsAccount extends Account {
    //@Column(nullable = false)
    private Double yieldRate;

    public Double getYieldRate() {
        return yieldRate;
    }

    public void setYieldRate(Double yieldRate) {
        this.yieldRate = yieldRate;
    }
}
