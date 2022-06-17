package br.com.foursys.fourpay.service;

import br.com.foursys.fourpay.model.CreditCard;
import br.com.foursys.fourpay.model.DebitCard;
import br.com.foursys.fourpay.repository.CreditCardRepository;
import br.com.foursys.fourpay.repository.DebitCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Object getCreditCardByiD(Integer accountId) {
        List<CreditCard> creditCardList = findAllCreditCard();
        for (CreditCard item : creditCardList) {
            if (item.getAccount().getId().equals(accountId)) {
                return item;
            }
        }
        return null;
    }

    public CreditCard saveCreditCard(CreditCard creditCard) {
        List<CreditCard> creditCardList = findAllCreditCard();
        for (CreditCard item : creditCardList) {
            if (item.getAccount().getId().equals(creditCard.getAccount().getId())) {
                return null;
            }
        }
        return creditCardRepository.save(creditCard);
    }

    public CreditCard findCreditById (String string){
    	List<CreditCard> creditCardList = findAllCreditCard();
        for (CreditCard item : creditCardList) {
            if (item.getCardNumber().equals(string)) {
                return item;
                
            }
        }
    	return null;
    }

    // DEBIT CARD METHODS STARTS HERE

    public List<DebitCard> findAllDebitCard() {
        return debitCardRepository.findAll();
    }

    public Object getDebitCardByiD(Integer accountId) {
        List<DebitCard> debitCardList = findAllDebitCard();
        for (DebitCard item : debitCardList) {
            if (item.getAccount().getId().equals(accountId)) {
                return item;
            }
        }
        return null;
    }

    public DebitCard saveDebitCard(DebitCard debitCard) {
        List<DebitCard> debitCardList = findAllDebitCard();
        for (DebitCard item : debitCardList) {
            if (item.getAccount().getId().equals(debitCard.getAccount().getId())) {
                return null;
            }
        }
        return debitCardRepository.save(debitCard);
    }

    public Optional<DebitCard> findDebitById(Integer debitCardId) {
        return debitCardRepository.findById(debitCardId);
    }

	public Optional<CreditCard> findCreditById(Integer creditCardId) {
		return creditCardRepository.findById(creditCardId);
	}
}
