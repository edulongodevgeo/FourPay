package br.com.foursys.fourpay.dto;

import br.com.foursys.fourpay.enums.PixKeyType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PixDTO {

    @NotNull
    private PixKeyType pixKeyType;
    @NotNull
    private String keyValue;
    @NotNull
    private Integer accountId;
    private boolean isActive;

    public PixKeyType getPixKeyType() {
        return pixKeyType;
    }

    public void setPixKeyType(PixKeyType pixKeyType) {
        this.pixKeyType = pixKeyType;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}
