package br.com.foursys.fourpay.controllers;

import br.com.foursys.fourpay.dto.CardCreationDTO;
import br.com.foursys.fourpay.enums.model.CreditCard;
import br.com.foursys.fourpay.repository.CreditCardRepository;
import br.com.foursys.fourpay.service.AccountService;
import br.com.foursys.fourpay.service.CardService;
import org.apache.coyote.Response;
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
    public CreditCard postCreateNewCreditCard(@PathVariable UUID accountId, @RequestBody CardCreationDTO cardCreationDTO) {
        CreditCard creditCard = new CreditCard();
        BeanUtils.copyProperties(cardCreationDTO, creditCard);
        creditCard.setFlag("MASTERCARD");
        creditCard.setCardNumber(generateCardNumber());
       // creditCard.setAccount(accountService.getAccountById(accountId));
        return creditCard;

    }

    private String generateCardNumber() {
        String cardNumber = "";
        while (cardNumber.length() < 16) {
            cardNumber += (int) (Math.random() * 10);
        }
        if (cardNumber.charAt(0) == '0') {
            cardNumber = cardNumber.substring(1);
        }
        return cardNumber;
    }

}

