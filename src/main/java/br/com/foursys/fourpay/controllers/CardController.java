package br.com.foursys.fourpay.controllers;

import br.com.foursys.fourpay.dto.CardCreationDTO;
import br.com.foursys.fourpay.model.CreditCard;
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
        creditCard.setFlag(generateCardFlag());
        creditCard.setCardNumber(generateCardNumber());
       // creditCard.setAccount(accountService.getAccountById(accountId));
        return creditCard;

    }

    private String generateCardFlag() {
        // generate credit card flag from the best flags of the world
        String[] flags = {"American Express", "Visa", "MasterCard", "Discover", "Diners Club", "JCB"};
        int random = (int) (Math.random() * flags.length);
        return flags[random];
    }

    private String generateCardNumber() {
        // generate a credit card number with 16 digits with the first digit 4
        String cardNumber = "";
        for (int i = 0; i < 16; i++) {
            if(i == 0) {
                cardNumber += "4";
            } else {
                cardNumber += (int) (Math.random() * 10);
            }
        }
        return cardNumber;
    }


}

