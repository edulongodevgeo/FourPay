package br.com.foursys.fourpay.service;

import br.com.foursys.fourpay.model.Account;
import br.com.foursys.fourpay.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    AccountService accountService;
    @Autowired
    TransactionRepository transactionRepository;

    public Object depositValue(Integer accountId, Double depositValue){
        Account account = accountService.findById(accountId).get();
        account.setBalance(account.getBalance() + depositValue);
        accountService.save(account);
        return account;
    }

    public Object withdrawValue(Integer accountId, Double withdrawValue){
        Account account = accountService.findById(accountId).get();
        if(account.getBalance() >= withdrawValue){
            account.setBalance(account.getBalance() - withdrawValue);
            accountService.save(account);
            return account;
        }else {
        	return null;        }
      }

    public Object transferValue(Integer payerId, Integer receiverId, Double transferValue){
        Account accountPayer = accountService.findById(payerId).get();
        Account accountReceiver = accountService.findById(receiverId).get();
    	if (accountPayer.getBalance() >= transferValue) {
    	        accountPayer.setBalance(accountPayer.getBalance() - transferValue);
    	        accountService.save(accountPayer);
    	        accountReceiver.setBalance(accountReceiver.getBalance() + transferValue);
    	        accountService.save(accountReceiver);
    	        return accountPayer;
        } else {
            return null;
        }
		
    }

    public void transferPixValue(Account account, Double transferValue){
       if (account.getBalance() >= transferValue) {
           account.setBalance(account.getBalance() - transferValue);
    }
    }

    public boolean validantionBalance(Account account, Double value){
        if(account.getBalance() >= value){
            return true;
        }
        return false;
    }

    public TransactionService updateBalance(Account account) {
        return updateBalance(account);
    }
    
}
