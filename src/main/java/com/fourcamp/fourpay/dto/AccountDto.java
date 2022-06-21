package com.fourcamp.fourpay.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Dto's dados de entrada é um padrão de projeto de software usado para transferir dados entre subsistemas de um software.
// DTOs são frequentemente usados em conjunção com objetos de acesso a dados para obter dados de um banco de dados.
// Por isso no xml temos o starter-validation pois criamos as verificações
// Recebemos esses dados no dto de campos obrigatorios, não precisa do UUID por gera automatico e coisas que,
// O cliente não altere o registro

public class AccountDto {

    @NotBlank
    @Size(max = 20)
    private String accountNumber;
    @NotBlank
    private String agencyNumber;
    @NotNull
    private Double balance;

    private Integer clientId;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAgencyNumber() {
        return agencyNumber;
    }

    public void setAgencyNumber(String agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}