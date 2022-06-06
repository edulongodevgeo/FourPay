package br.com.foursys.fourpay.enums;

public enum PixKeyType {
    CPF(0),
    EMAIL(1),
    TELEFONE(2),
    ALEATORIO(3);

    private Integer id;
    PixKeyType(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
