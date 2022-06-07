package br.com.foursys.fourpay.model;

import javax.persistence.Entity;

@Entity
public class SavingsAccount {

    private Double yieldRate;

    public SavingsAccount() {
    }

    //YIELDRATE.EQUALS (TAXA DE RENDIMENTO)
    public SavingsAccount(Double yieldRate) {
        this.yieldRate = yieldRate;
    }

    public Double getYieldRate() {
        return yieldRate;
    }

    public void setYieldRate(Double yieldRate) {
        this.yieldRate = yieldRate;
    }
}
