package br.com.foursys.fourpay.service;

import br.com.foursys.fourpay.model.Account;
import br.com.foursys.fourpay.model.CheckingsAccount;
import br.com.foursys.fourpay.model.SavingsAccount;
import br.com.foursys.fourpay.repository.AccountRepository;
import br.com.foursys.fourpay.repository.CheckingsAccountRepository;
import br.com.foursys.fourpay.repository.SavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


// É uma camada intermediária entre model e repository e importante para diminuir acoplamento
// É um bin do spring como é uma camada de serviço tem algo especifico para isso @Service
// Dentro do service tem que criar um ponto de injeção, ele precisará acionar o Repository em casos de salvar, listar e etc
// Transações em si controller aciona o service e o service aciona o repository
// avisa ao spring em determinado momento para injetar
// Só que a boa pratica recomenda a construção de um construtor ao inves de @Autowired
// e assim passar as dependencias que ele será solicitado em determinados momentos
// Transactional anotar principalmente quando tem relacionamentos em cascata
// Acaso algo der errado ele garante o rollback e não tenha dados quebrados

@Service
public class AccountService {
    @Autowired
    CheckingsAccountRepository checkingsAccountRepository;
    @Autowired
    SavingsAccountRepository savingsAccountRepository;
    final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Optional<Account> findById(Integer id) {
        return accountRepository.findById(id);
    }

    @Transactional
    public CheckingsAccount createCheckingsAccount(CheckingsAccount account) {
       return  checkingsAccountRepository.save(account);
    }

    @Transactional
    public SavingsAccount createSavingsAccount(SavingsAccount savingsAccount) {
        return savingsAccountRepository.save(savingsAccount);
    }

    @Transactional
    public boolean updateBalance(Account account, Double value) {
        if (account.getBalance() >= value) {
            account.setBalance(account.getBalance() - value);
            accountRepository.save(account);
            return true;
        } else {
            return false;
        }
    }

    public List<CheckingsAccount> updateAllCreditAccountsByAnniversary() {
        List<CheckingsAccount> checkingsAccounts = checkingsAccountRepository.findAll();
        for (CheckingsAccount account : checkingsAccounts) {
            if (account.getAccountAniversary().equals(LocalDateTime.now().minusDays(30))) {
                account.setBalance(account.getBalance() - account.getMaintenanceRate());
                account.setAccountAniversary(LocalDateTime.now());
                checkingsAccountRepository.save(account);
            }
        }
        return checkingsAccounts;
    }

    public List<SavingsAccount> updateAllSavingsAccountsByAnniversary() {
        List<SavingsAccount> savingsAccounts = savingsAccountRepository.findAll();
        for (SavingsAccount account : savingsAccounts) {
            if (account.getAccountAniversary().equals(LocalDateTime.now().minusDays(30))) {
                account.setBalance(account.getBalance() + (account.getBalance() * account.getYieldRate()));
                account.setAccountAniversary(LocalDateTime.now());
                savingsAccountRepository.save(account);
            }
        }
        return savingsAccounts;
    }
}
