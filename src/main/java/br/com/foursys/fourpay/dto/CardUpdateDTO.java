package br.com.foursys.fourpay.dto;

public class CardUpdateDTO {
    private String password;
    private Boolean isActive;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
