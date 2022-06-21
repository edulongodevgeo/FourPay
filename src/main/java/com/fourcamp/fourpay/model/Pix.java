package com.fourcamp.fourpay.model;

import com.fourcamp.fourpay.enums.PixKeyType;

import javax.persistence.*;

@Entity
@Table(name = "pix")
public class Pix {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, length = 6)
    private Integer id;
    @Column(length = 15)
    private PixKeyType pixKeyType;
    @Column(length = 140)
    private String keyValue;
    @Column
    private boolean isActive;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Pix() {
    }

    public Pix(Integer id, PixKeyType pixKeyType, String keyValue, boolean isActive, Account account) {
        this.id = id;
        this.pixKeyType = pixKeyType;
        this.isActive = isActive;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}


