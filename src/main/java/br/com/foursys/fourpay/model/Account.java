package br.com.foursys.fourpay.model;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
<<<<<<< HEAD
    @Column(nullable = false, unique = true)
    private String accountNumber;
    @Column(nullable = false, unique = false, updatable = true)
    private String agencyNumber;
    @Column(nullable = false, updatable = true)
=======
    private String number;
>>>>>>> 0d50a26ec34e7de7af8643ce336cd1d116dfa544
    private Double balance;
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

<<<<<<< HEAD
=======
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Account() {
    }

    public Account(Integer id, String number, Double balance, Client client) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.client = client;
    }

>>>>>>> 0d50a26ec34e7de7af8643ce336cd1d116dfa544
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

<<<<<<< HEAD
    public String getAgencyNumber() {
        return agencyNumber;
    }

    public void setAgencyNumber(String agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

=======
>>>>>>> 0d50a26ec34e7de7af8643ce336cd1d116dfa544
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
<<<<<<< HEAD

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
=======
>>>>>>> 0d50a26ec34e7de7af8643ce336cd1d116dfa544
}

