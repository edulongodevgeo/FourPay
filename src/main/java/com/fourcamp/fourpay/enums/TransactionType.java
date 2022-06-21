package com.fourcamp.fourpay.enums;

public enum TransactionType {
    CREDIT(0),
    DEBIT(1),
    PIX(2),
    DEPOSIT(3),
    WITHDRAW(4),
    TRANSFER(5);

    private Integer id;

    TransactionType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
