package br.com.foursys.fourpay.model;

import javax.persistence.*;

@Entity
//@SequenceGenerator(allocationSize = 1, sequenceName = "sq_insurence", name = "Insurnace")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String rules;

    public Insurance() {
    }

    public Insurance(String name, String rules) {
        this.name = name;
        this.rules = rules;
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

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }
}
