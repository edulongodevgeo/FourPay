package br.com.foursys.fourpay.model;

//Criando Entity para ele ser uma tabela no banco de dados e criar mapeamento
//Criando o Table que será criado na base de dados e seu nome.


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String number;
    @Column(nullable = false, unique = false, updatable = true)
    private String agency;
    @Column(nullable = false, updatable = true)
    private Double balance;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(nullable = false)
    private LocalDateTime registrationDateAccount;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public LocalDateTime getRegistrationDateAccount() {
        return registrationDateAccount;
    }

    public void setRegistrationDateAccount(LocalDateTime registrationDateAccount) {
        this.registrationDateAccount = registrationDateAccount;
    }
}
