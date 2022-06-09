package br.com.foursys.fourpay.model;

import br.com.foursys.fourpay.enums.PixKeyType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table (name = "pix")
public class Pix {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private PixKeyType pixKeyType;
    private Double value;
    private LocalDateTime date;
    private String keyContent;
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
