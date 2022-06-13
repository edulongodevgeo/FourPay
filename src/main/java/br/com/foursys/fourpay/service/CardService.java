package br.com.foursys.fourpay.service;

import br.com.foursys.fourpay.model.CreditCard;
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

    public List<CreditCard> findAll() {
        return creditCardRepository.findAll();
    }

    public Object getCreditCardByiD(UUID accountId) {
        List<CreditCard> creditCardList = findAll();
        for (CreditCard item : creditCardList) {
            if (item.getAccount().getId().equals(accountId)){
                return item;
            }
        }
        return null;
    }
}
