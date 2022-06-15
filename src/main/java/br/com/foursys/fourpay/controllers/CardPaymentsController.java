package br.com.foursys.fourpay.controllers;

import br.com.foursys.fourpay.dto.PaymentWithCreditDTO;
import br.com.foursys.fourpay.dto.PaymentWithDebitDTO;
import br.com.foursys.fourpay.service.CardPaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cardPayments")
public class CardPaymentsController {
    @Autowired
    CardPaymentsService cardPaymentsService;

    @PostMapping("/credit")
    public ResponseEntity<Object> paymentWithCredit(@RequestBody PaymentWithCreditDTO paymentWithCreditDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(cardPaymentsService.paymentWithCredit(paymentWithCreditDTO));
    }

    @PostMapping("/debit")
    public ResponseEntity<Object> paymentWithDebit(@RequestBody PaymentWithDebitDTO paymentWithDebitDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(cardPaymentsService.paymentWithDebit(paymentWithDebitDTO));
    }

}


