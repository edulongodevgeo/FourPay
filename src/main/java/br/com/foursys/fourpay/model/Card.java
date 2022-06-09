/*
package br.com.foursys.fourpay.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Card {
	@Id
    private String numberCard;
    private String flag;
    private String password;
    private Boolean isActive;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card() {
    }

    public Card(String numberCard, String flag, String password, Boolean isActive, Account account) {
        this.numberCard = numberCard;
        this.flag = flag;
        this.password = password;
        this.isActive = isActive;
//        this.account = account;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
}
<<<<<<< HEAD

=======
*/
>>>>>>> 40b1ea976f42ca040910ad7fe1dac0e4930f60b9
