package br.com.foursys.fourpay.service;

import br.com.foursys.fourpay.model.CreditCard;
import br.com.foursys.fourpay.model.DebitCard;
import br.com.foursys.fourpay.repository.CreditCardRepository;
import br.com.foursys.fourpay.repository.DebitCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CardService {
    @Autowired
    CreditCardRepository creditCardRepository;
    @Autowired
    DebitCardRepository debitCardRepository;

    // CREDIT CARD METHODS STARTS HERE
    public List<CreditCard> findAllCreditCard() {
        return creditCardRepository.findAll();
    }

    public Object getCreditCardByiD(UUID accountId) {
        List<CreditCard> creditCardList = findAllCreditCard();
        for (CreditCard item : creditCardList) {
            if (item.getAccount().getId().equals(accountId)) {
                return item;
            }
        }
        return null;
    }

    public CreditCard saveCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    // DEBIT CARD METHODS STARTS HERE

    public List<DebitCard> findAllDebitCard() {
        return debitCardRepository.findAll();
    }

    public Object getDebitCardByiD(UUID accountId) {
        List<DebitCard> debitCardList = findAllDebitCard();
        for (DebitCard item : debitCardList) {
            if (item.getAccount().getId().equals(accountId)) {
                return item;
            }
        }
        return null;
    }

    public DebitCard saveDebitCard(DebitCard debitCard) {
        return debitCardRepository.save(debitCard);
    }

}
