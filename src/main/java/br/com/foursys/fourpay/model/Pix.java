package br.com.foursys.fourpay.model;

import br.com.foursys.fourpay.enums.PixKeyType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "pix")
public class Pix {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, length = 6)
    private Integer id;
    @Column(length = 15)
    private PixKeyType pixKeyType;
    @Column(length = 8, nullable = false)
    private Double value;
    @Column(length = 30)
    private LocalDateTime date;
    @Column(length = 140)
    private String keyContent;
    @Column
    private Boolean isActive;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Pix() {
    }

    public Pix(Integer id, PixKeyType pixKeyType, Double value, LocalDateTime date, String keyContent, Boolean isActive, Account account) {
        this.id = id;
        this.pixKeyType = pixKeyType;
        this.value = value;
        this.date = date;
        this.keyContent = keyContent;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime  getDate() {
        return date;
    }

    public void setDate(LocalDateTime  date) {
        this.date = date;
    }

    public String getKeyContent() {
        return keyContent;
    }

    public void setKeyContent(String keyContent) {
        this.keyContent = keyContent;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
 }
