package br.com.foursys.fourpay.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "card_id")
    private CreditCard creditCard;

    private LocalDate datePolicy;
    @OneToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;
    private Double valuePolicy;
    private String conditionsDescriptions;

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Policy() {
    }

    public Policy(UUID id, CreditCard creditCard, Insurance insurance, Double valuePolicy, String conditionsDescriptions) {
        this.id = id;
        this.creditCard = creditCard;
        this.insurance = insurance;
        this.valuePolicy = valuePolicy;
        this.conditionsDescriptions = conditionsDescriptions;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public LocalDate getDatePolicy() {
        return datePolicy;
    }

    public void setDatePolicy(LocalDate datePolicy) {
        this.datePolicy = datePolicy;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getValuePolicy() {
        return valuePolicy;
    }

    public void setValuePolicy(Double valuePolicy) {
        this.valuePolicy = valuePolicy;
    }

    public String getConditionsDescriptions() {
        return conditionsDescriptions;
    }

    public void setConditionsDescriptions(String conditionsDescriptions) {
        this.conditionsDescriptions = conditionsDescriptions;
    }
}
