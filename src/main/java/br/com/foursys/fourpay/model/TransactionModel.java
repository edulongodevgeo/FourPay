package br.com.foursys.fourpay.model;

import br.com.foursys.fourpay.enums.TransactionType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Entity
public class TransactionModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer transactionId;
    private Double value;
    private LocalDateTime dateOfTransaction;
    private TransactionType transactionType;
    private String payee;
    private String payer;
    private Double balance;

       public TransactionModel(Integer transactionId, Double value, LocalDateTime dateOfTransaction, TransactionType transactionType, String payee, String payer, Double balance) {
        this.transactionId = transactionId;
        this.value = value;
        this.dateOfTransaction = dateOfTransaction;
        this.transactionType = transactionType;
        this.payee = payee;
        this.payer = payer;
        this.balance = balance;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(LocalDateTime dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getPayee() {
        return payee;
    }
    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
