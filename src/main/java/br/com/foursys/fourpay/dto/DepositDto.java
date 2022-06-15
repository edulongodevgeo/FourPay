package br.com.foursys.fourpay.dto;

import br.com.foursys.fourpay.model.Account;

public class DepositDto {

    private Double depositValue;
    private Integer accountId;

    public Double getDepositValue() {
        return depositValue;
    }

    public void setDepositValue(Double depositValue) {
        this.depositValue = depositValue;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
