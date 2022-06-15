package br.com.foursys.fourpay.controllers;

import br.com.foursys.fourpay.dto.CardCreationDTO;
import br.com.foursys.fourpay.dto.CardUpdateDTO;
import br.com.foursys.fourpay.enums.ClientType;
import br.com.foursys.fourpay.model.Client;
import br.com.foursys.fourpay.model.CreditCard;
import br.com.foursys.fourpay.model.DebitCard;
import br.com.foursys.fourpay.service.AccountService;
import br.com.foursys.fourpay.service.CardService;
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
    public ResponseEntity<Object> getCreditCardById(@PathVariable Integer accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.getCreditCardByiD(accountId));
    }

    @PostMapping("/{accountId}/credit")
    public ResponseEntity<Object> postCreateNewCreditCard(@PathVariable Integer accountId, @RequestBody CardCreationDTO cardCreationDTO) {
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
    public ResponseEntity<Object> putUpdateCreditCard(@PathVariable Integer accountId, @RequestBody CardUpdateDTO cardUpdateDTO) {
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
    public ResponseEntity<Object> getDebitCardById(@PathVariable Integer accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.getDebitCardByiD(accountId));
    }
    @PostMapping("/{accountId}/debit")
    public ResponseEntity<Object> postCreateNewDebitCard(@PathVariable Integer accountId, @RequestBody CardCreationDTO cardCreationDTO) {
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
    public ResponseEntity<Object> putUpdateDebitCard(@PathVariable Integer accountId, @RequestBody CardUpdateDTO cardUpdateDTO) {
        DebitCard debitCard = (DebitCard) cardService.getDebitCardByiD(accountId);
        if(cardUpdateDTO.getPassword() != null) {
            debitCard.setPassword(cardUpdateDTO.getPassword());
        }
        if(cardUpdateDTO.getActive() != null) {
            debitCard.setIsActive(cardUpdateDTO.getActive());
        }
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

