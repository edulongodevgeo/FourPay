package br.com.foursys.fourpay.dto;

import java.util.UUID;

public class CardCreationDTO {
    private String password;
    private UUID accountId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }
}
