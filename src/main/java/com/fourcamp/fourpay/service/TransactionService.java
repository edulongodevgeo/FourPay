package com.fourcamp.fourpay.service;

import com.fourcamp.fourpay.dto.PaymentWithCreditDTO;
import com.fourcamp.fourpay.dto.PaymentWithDebitDTO;
import com.fourcamp.fourpay.enums.TransactionType;
import com.fourcamp.fourpay.model.*;
import com.fourcamp.fourpay.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

	@Autowired
	AccountService accountService;
	@Autowired
    TransactionRepository transactionRepository;

	public Transaction depositValue(Integer accountId, Double depositValue) {
		Account account = accountService.findById(accountId).get();
		account.setBalance(account.getBalance() + depositValue);
		accountService.save(account);

		Transaction transaction = new Transaction();
		transaction.setDateOfTransaction(LocalDateTime.now());
		transaction.setTransactionType(TransactionType.DEPOSIT);
		transaction.setValue(depositValue);
		transaction.setPayerId(accountId);
		transaction.setReceiverId(accountId);
		return transactionRepository.save(transaction);
	}

	public Transaction withdrawValue(Integer accountId, Double withdrawValue) {
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
			return transactionRepository.save(transaction);
		} else {
			return null;
		}
	}

	public Transaction transferValue(Integer payerId, Integer receiverId, Double transferValue) {
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
			return transactionRepository.save(transaction);
		} else {
			return null;
		}

	}

	public void transferPixValue(Account account, Double transferValue) {
		if (account.getBalance() >= transferValue) {
			account.setBalance(account.getBalance() - transferValue);
		}
	}

	public Transaction saveCreditPayment(CreditCard creditCard, PaymentWithCreditDTO paymentWithCreditDTO) {
		Transaction transaction = new Transaction();
		transaction.setTransactionType(TransactionType.CREDIT);
		transaction.setDateOfTransaction(LocalDateTime.now());
		transaction.setValue(paymentWithCreditDTO.getValue());
		transaction.setPayerId(creditCard.getAccount().getId());
		transaction.setReceiverId(null);
		transaction.setDescription(paymentWithCreditDTO.getDescription());
		return transactionRepository.save(transaction);
	}

	public Transaction saveDebitPayment(DebitCard debitCard, PaymentWithDebitDTO paymentWithDebitDTO) {
		Transaction transaction = new Transaction();
		transaction.setTransactionType(TransactionType.DEBIT);
		transaction.setDateOfTransaction(LocalDateTime.now());
		transaction.setValue(paymentWithDebitDTO.getValue());
		transaction.setPayerId(debitCard.getAccount().getId());
		transaction.setReceiverId(null);
		transaction.setDescription(paymentWithDebitDTO.getDescription());
		return transactionRepository.save(transaction);
	}

	public void rechargeCellPhone(Recharge recharge) {
		Transaction transaction = new Transaction();
		transaction.setTransactionType(recharge.getPaymentMethod());
		transaction.setDateOfTransaction(LocalDateTime.now());
		transaction.setValue(recharge.getValue());
		transaction.setPayerId(null);
		transaction.setReceiverId(null);
		transaction.setDescription("Recarga efetuada no n??mero " + recharge.getCellphoneNumber() + ". Valor: "
				+ recharge.getValue() + ".");
		transactionRepository.save(transaction);
	}

	public Transaction transferPix(Transaction transaction) {
		Account payerAccount = accountService.findById(transaction.getPayerId()).get();
		Account receiverAccount = accountService.findById(transaction.getReceiverId()).get();
		if (payerAccount.getBalance() >= transaction.getValue()) {
			payerAccount.setBalance(payerAccount.getBalance() - transaction.getValue());
			accountService.save(payerAccount);
			receiverAccount.setBalance(receiverAccount.getBalance() + transaction.getValue());
			accountService.save(receiverAccount);
			return transactionRepository.save(transaction);
		} else {
			return null;
		}
	}

	public List<Transaction> getAllTransaction() {
		List<Transaction> fullList = transactionRepository.findAll();
		List<Transaction> returnList = new ArrayList<>();
		return fullList;
	}

	public List<Transaction> getByIdTransaction(Integer id) {
		List<Transaction> returnList = new ArrayList<>();
		List<Transaction> returnListById = getAllTransaction();

		for (Transaction transaction : returnListById) {
			if (transaction.getPayerId() != null) {
				if (transaction.getPayerId().equals(id)) {
					returnList.add(transaction);
				}
				if (transaction.getReceiverId() != null) {
					if (transaction.getReceiverId().equals(id)) {
						returnList.add(transaction);
					}
				}	
			}
		}
		return returnList;
	}
}