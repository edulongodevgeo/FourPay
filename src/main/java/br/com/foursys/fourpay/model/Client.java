package br.com.foursys.fourpay.model;

import br.com.foursys.fourpay.enums.ClientType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String cpf;
    private String password;
    private String email;
    private String cellphone;
    private LocalDateTime birthDate;
    private Double monthlyIncome;
    private ClientType clientType;
    private Address address;
    private DateTimeFormat birthDate;
    private Double monthlyIncome;
    private ClientType clientType;
    //private Address address;

    public Client() {
    }

    public Client(String name, String cpf, String password, String email, String cellphone, LocalDateTime birthDate, ClientType clientType, Address address) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.address = address;

    public Client(String name, String cpf, String password, String email, String cellphone, ClientType clientType ) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.address = address;
        this.cellphone = cellphone;
        this.email = email;
        this.password = password;
        this.clientType = clientType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {

    public DateTimeFormat getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTimeFormat birthDate) {

        this.birthDate = birthDate;
    }

    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

   public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
   public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
