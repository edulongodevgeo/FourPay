package br.com.foursys.fourpay.service;

import br.com.foursys.fourpay.dto.PaymentWithCreditDTO;
import br.com.foursys.fourpay.dto.PaymentWithDebitDTO;
import br.com.foursys.fourpay.model.CreditCard;
import br.com.foursys.fourpay.model.DebitCard;
import br.com.foursys.fourpay.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardPaymentsService {
    private static final Double CREDIT_CARD_FEE = 0.99;
    private static final Double DEBIT_CARD_FEE = 0.99;
    @Autowired
    CardService cardService;
    @Autowired
    TransactionService transactionService;
    @Autowired
    AccountService accountService;

    
    public Transaction paymentWithCredit(PaymentWithCreditDTO paymentWithCreditDTO) {
        CreditCard creditCard = cardService.findCreditById(paymentWithCreditDTO.getCreditCardId()).get();
        if (creditCard.getLimitCredit() >= paymentWithCreditDTO.getValue() + CREDIT_CARD_FEE) {
            creditCard.setLimitCredit(creditCard.getLimitCredit() - paymentWithCreditDTO.getValue() + CREDIT_CARD_FEE);
            cardService.saveCreditCard(creditCard);
            return transactionService.saveCreditPayment(creditCard, paymentWithCreditDTO);
        } else {
            return null;
        }

    }

    public Transaction paymentWithDebit(PaymentWithDebitDTO paymentWithDebitDTO) {
        DebitCard debitCard = cardService.findDebitById(paymentWithDebitDTO.getDebitCardId()).get();
        if (debitCard.getTransactionLimit() >= paymentWithDebitDTO.getValue() + DEBIT_CARD_FEE) {
            debitCard.setTransactionLimit(debitCard.getTransactionLimit() - paymentWithDebitDTO.getValue() + DEBIT_CARD_FEE);
            if (accountService.updateBalance(debitCard.getAccount(), paymentWithDebitDTO.getValue())) {
                cardService.saveDebitCard(debitCard);
                return transactionService.saveDebitPayment(debitCard, paymentWithDebitDTO);
            }
        }
        return null;

    }
}
