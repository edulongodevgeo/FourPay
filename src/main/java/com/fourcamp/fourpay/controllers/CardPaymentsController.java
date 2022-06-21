package com.fourcamp.fourpay.controllers;

import com.fourcamp.fourpay.dto.PaymentWithCreditDTO;
import com.fourcamp.fourpay.dto.PaymentWithDebitDTO;
import com.fourcamp.fourpay.model.Transaction;
import com.fourcamp.fourpay.service.CardPaymentsService;
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
    public ResponseEntity<Transaction> paymentWithCredit(@RequestBody PaymentWithCreditDTO paymentWithCreditDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(cardPaymentsService.paymentWithCredit(paymentWithCreditDTO)); 
    }

    @PostMapping("/debit")
    public ResponseEntity<Transaction> paymentWithDebit(@RequestBody PaymentWithDebitDTO paymentWithDebitDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(cardPaymentsService.paymentWithDebit(paymentWithDebitDTO));
    }

}


