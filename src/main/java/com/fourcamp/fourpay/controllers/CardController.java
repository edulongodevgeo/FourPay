package com.fourcamp.fourpay.controllers;

import com.fourcamp.fourpay.dto.CardCreationDTO;
import com.fourcamp.fourpay.dto.CardUpdateDTO;
import com.fourcamp.fourpay.dto.DebitLimitUpdateDTO;
import com.fourcamp.fourpay.enums.ClientType;
import com.fourcamp.fourpay.model.Client;
import com.fourcamp.fourpay.model.CreditCard;
import com.fourcamp.fourpay.model.DebitCard;
import com.fourcamp.fourpay.service.AccountService;
import com.fourcamp.fourpay.service.CardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;
    @Autowired
    AccountService accountService;

    @GetMapping("/{accountId}/credit")
    public ResponseEntity<CreditCard> getCreditCardById(@PathVariable Integer accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.getCreditCardByiD(accountId));
    }

    @PostMapping("/{accountId}/credit")
    public ResponseEntity<CreditCard> postCreateNewCreditCard(@PathVariable Integer accountId, @RequestBody CardCreationDTO cardCreationDTO) {
        CreditCard creditCard = new CreditCard();
        BeanUtils.copyProperties(cardCreationDTO, creditCard);
        creditCard.setAccount(accountService.findById(accountId).get());
        creditCard.setFlag("MASTERCARD");
        creditCard.setCardNumber(generateCardNumber());
        creditCard.setLimitCredit(determineLimit(creditCard.getAccount().getClient()));
        creditCard.setIsActive(true);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.saveCreditCard(creditCard));
    }

    @PutMapping("/{accountId}/credit")
    public ResponseEntity<CreditCard> putUpdateCreditCard(@PathVariable Integer accountId, @RequestBody CardUpdateDTO cardUpdateDTO) {
        CreditCard creditCard = (CreditCard) cardService.getCreditCardByiD(accountId);
        if(cardUpdateDTO.getPassword() != null) {
            creditCard.setPassword(cardUpdateDTO.getPassword());
        }
        if(cardUpdateDTO.getActive() != null) {
            creditCard.setIsActive(cardUpdateDTO.getActive());
        }
        return ResponseEntity.status(HttpStatus.OK).body(cardService.saveCreditCard(creditCard));
    }

    @GetMapping("/{accountId}/debit")
    public ResponseEntity<DebitCard> getDebitCardById(@PathVariable Integer accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.getDebitCardByiD(accountId));
    }
    @PostMapping("/{accountId}/debit")
    public ResponseEntity<DebitCard> postCreateNewDebitCard(@PathVariable Integer accountId, @RequestBody CardCreationDTO cardCreationDTO) {
        DebitCard debitCard = new DebitCard();
        BeanUtils.copyProperties(cardCreationDTO, debitCard);
        debitCard.setAccount(accountService.findById(accountId).get());
        debitCard.setFlag("VISA");
        debitCard.setCardNumber(generateCardNumber());
        debitCard.setTransactionLimit(determineLimit(debitCard.getAccount().getClient()));
        debitCard.setIsActive(true);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.saveDebitCard(debitCard));
    }

    @PutMapping("/{accountId}/debit")
    public ResponseEntity<DebitCard> putUpdateDebitCard(@PathVariable Integer accountId, @RequestBody CardUpdateDTO cardUpdateDTO) {
        DebitCard debitCard = (DebitCard) cardService.getDebitCardByiD(accountId);
        if(cardUpdateDTO.getPassword() != null) {
            debitCard.setPassword(cardUpdateDTO.getPassword());
        }
        if(cardUpdateDTO.getActive() != null) {
            debitCard.setIsActive(cardUpdateDTO.getActive());
        }
        return ResponseEntity.status(HttpStatus.OK).body(cardService.saveDebitCard(debitCard));
    }

    @PutMapping("/{accountId}/debit/update-limit")
    public ResponseEntity<DebitCard> putUpdateDebitCardLimit(@PathVariable Integer accountId, @RequestBody DebitLimitUpdateDTO debitLimitUpdateDTO) {
        DebitCard debitCard = (DebitCard) cardService.getDebitCardByiD(accountId);
        debitCard.setTransactionLimit(debitLimitUpdateDTO.getTransactionLimit());
        return ResponseEntity.status(HttpStatus.OK).body(cardService.saveDebitCard(debitCard));
    }

    private Double determineLimit(Client client) {
        if (client.getClientType().equals(ClientType.COMUM)) {
            return 1000.0;
        } else if (client.getClientType().equals(ClientType.SUPER)) {
            return 2500.0;
        } else {
            return 15000.0;
        }
    }

    private String generateCardNumber() {
        String cardNumber = "";
        for (int i = 0; i < 16; i++) {
            if (i == 0) {
                cardNumber += "4";
            } else {
                cardNumber += (int) (Math.random() * 10);
            }
        }
        return cardNumber;
    }


}

