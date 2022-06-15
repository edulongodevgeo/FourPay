package br.com.foursys.fourpay.service;

import br.com.foursys.fourpay.enums.TransactionType;
import br.com.foursys.fourpay.model.Account;
import br.com.foursys.fourpay.model.Transaction;
import br.com.foursys.fourpay.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    AccountService accountService;
    @Autowired
    TransactionRepository transactionRepository;

    public Object depositValue(Integer accountId, Double depositValue) {
        Account account = accountService.findById(accountId).get();
        account.setBalance(account.getBalance() + depositValue);
        accountService.save(account);

        Transaction transaction = new Transaction();
        transaction.setDateOfTransaction(LocalDateTime.now());
        transaction.setTransactionType(TransactionType.DEPOSIT);
        transaction.setValue(depositValue);
        transaction.setPayerId(accountId);
        transaction.setReceiverId(accountId);
        transactionRepository.save(transaction);

        return account;
    }

    public Object withdrawValue(Integer accountId, Double withdrawValue) {
        Account account = accountService.findById(accountId).get();
        if (account.getBalance() >= withdrawValue) {
            account.setBalance(account.getBalance() - withdrawValue);
            accountService.save(account);

            Transaction transaction = new Transaction();
            transaction.setDateOfTransaction(LocalDateTime.now());
            transaction.setTransactionType(TransactionType.WITHDRAW);
            transaction.setValue(withdrawValue);
            transaction.setPayerId(accountId);
            transaction.setReceiverId(accountId);
            transactionRepository.save(transaction);

            return account;
        } else {
            return null;
        }
    }

    public Object transferValue(Integer payerId, Integer receiverId, Double transferValue) {
        Account accountPayer = accountService.findById(payerId).get();
        Account accountReceiver = accountService.findById(receiverId).get();
        if (accountPayer.getBalance() >= transferValue) {
            accountPayer.setBalance(accountPayer.getBalance() - transferValue);
            accountService.save(accountPayer);
            accountReceiver.setBalance(accountReceiver.getBalance() + transferValue);
            accountService.save(accountReceiver);

            Transaction transaction = new Transaction();
            transaction.setDateOfTransaction(LocalDateTime.now());
            transaction.setTransactionType(TransactionType.TRANSFER);
            transaction.setValue(transferValue);
            transaction.setPayerId(payerId);
            transaction.setReceiverId(receiverId);
            transactionRepository.save(transaction);

            return accountPayer;
        } else {
            return null;
        }

    }

    public void transferPixValue(Account account, Double transferValue) {
        if (account.getBalance() >= transferValue) {
            account.setBalance(account.getBalance() - transferValue);
        }
    }


}
