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
    private String accountNumber;
    @Column(nullable = false, unique = false, updatable = true)
    private String agencyNumber;
    @Column(nullable = false, updatable = true)
    private Double balance;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(nullable = false)
    private LocalDateTime registrationDateAccount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getRegistrationDateAccount() {
        return registrationDateAccount;
    }

    public void setRegistrationDateAccount(LocalDateTime registrationDateAccount) {
        this.registrationDateAccount = registrationDateAccount;
    }
}
