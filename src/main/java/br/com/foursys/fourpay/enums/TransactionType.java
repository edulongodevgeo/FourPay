package br.com.foursys.fourpay.enums;

public enum TransactionType {
    CREDIT(0),
    DEBIT(1),
    PIX(2);

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
