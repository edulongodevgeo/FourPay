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
    private Integer receiverId;
    private Integer payerId;
    private Double balance;

       public TransactionModel(Integer transactionId, Double value, LocalDateTime dateOfTransaction, TransactionType transactionType, Integer receiverId, Integer payerId, Double balance) {
        this.transactionId = transactionId;
        this.value = value;
        this.dateOfTransaction = dateOfTransaction;
        this.transactionType = transactionType;
        this.receiverId = receiverId;
        this.payerId = transactionId;
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

    public Integer getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}

	public Integer getPayerId() {
		return payerId;
	}

	public void setPayerId(Integer payerId) {
		this.payerId = payerId;
	}

	public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
