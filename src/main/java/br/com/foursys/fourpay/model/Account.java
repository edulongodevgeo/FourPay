package br.com.foursys.fourpay.model;

//Criando Entity para ele ser uma tabela no banco de dados e criar mapeamento
//Criando o Table que será criado na base de dados e seu nome.


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "account")
public class Account {

    private static final long serialVersionUID = 1L;

    //UUID por que porque quando trabalha com Arquiteturas de microservices onde tem sincronia de dados
    //São ids unicos que podem ser em qualquer lugar e universais e não corre o risco de conflitos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String number;
    @Column(nullable = false, unique = true, updatable = true)
    private String agency;
    @Column(nullable = false, updatable = true)
    private Double balance;
    @Column(nullable = false)
    private LocalDateTime registrationDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
