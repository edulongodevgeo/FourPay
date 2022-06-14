package br.com.foursys.fourpay.controllers;

import br.com.foursys.fourpay.dto.CardCreationDTO;
import br.com.foursys.fourpay.dto.CardUpdateDTO;
import br.com.foursys.fourpay.model.CreditCard;
import br.com.foursys.fourpay.model.DebitCard;
import br.com.foursys.fourpay.service.AccountService;
import br.com.foursys.fourpay.service.CardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;
    @Autowired
    AccountService accountService;

    @GetMapping("/{accountId}/credit")
    public ResponseEntity<Object> getCreditCardById(@PathVariable UUID accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.getCreditCardByiD(accountId));
    }

    @PostMapping("/{accountId}/credit")
    public ResponseEntity<Object> postCreateNewCreditCard(@PathVariable UUID accountId, @RequestBody CardCreationDTO cardCreationDTO) {
        CreditCard creditCard = new CreditCard();
        BeanUtils.copyProperties(cardCreationDTO, creditCard);
        // creditCard.setAccount(accountService.getAccountById(accountId));
        creditCard.setFlag("MASTERCARD");
        creditCard.setCardNumber(generateCardNumber());
        creditCard.setLimitCredit(determineLimit(creditCard.getAccount().getBalance()));
        creditCard.setIsActive(true);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.saveCreditCard(creditCard));
    }

    @PutMapping("/{accountId}/credit")
    public ResponseEntity<Object> putUpdateCreditCard(@PathVariable UUID accountId, @RequestBody CardUpdateDTO cardUpdateDTO) {
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
    public ResponseEntity<Object> getDebitCardById(@PathVariable UUID accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.getDebitCardByiD(accountId));
    }
    @PostMapping("/{accountId}/debit")
    public ResponseEntity<Object> postCreateNewDebitCard(@PathVariable UUID accountId, @RequestBody CardCreationDTO cardCreationDTO) {
        DebitCard debitCard = new DebitCard();
        BeanUtils.copyProperties(cardCreationDTO, debitCard);
        // creditCard.setAccount(accountService.getAccountById(accountId));
        debitCard.setFlag("VISA");
        debitCard.setCardNumber(generateCardNumber());
        debitCard.setTransactionLimit(determineLimit(debitCard.getAccount().getBalance()));
        debitCard.setIsActive(true);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.saveDebitCard(debitCard));
    }

    @PutMapping("/{accountId}/debit")
    public ResponseEntity<Object> putUpdateDebitCard(@PathVariable UUID accountId, @RequestBody CardUpdateDTO cardUpdateDTO) {
        DebitCard debitCard = (DebitCard) cardService.getDebitCardByiD(accountId);
        if(cardUpdateDTO.getPassword() != null) {
            debitCard.setPassword(cardUpdateDTO.getPassword());
        }
        if(cardUpdateDTO.getActive() != null) {
            debitCard.setIsActive(cardUpdateDTO.getActive());
        }
        return ResponseEntity.status(HttpStatus.OK).body(cardService.saveDebitCard(debitCard));
    }

    private Double determineLimit(Double balance) {
        if (balance < 2000) {
            return 1000.0;
        } else if (balance < 5000) {
            return 2500.0;
        } else {
            return 15000.0;
        }
    }

    private String generateCardNumber() {
        // generate a credit card number with 16 digits with the first digit 4
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

