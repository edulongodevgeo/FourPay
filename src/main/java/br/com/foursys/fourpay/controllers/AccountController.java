package br.com.foursys.fourpay.controllers;


import br.com.foursys.fourpay.dto.AccountDto;
import br.com.foursys.fourpay.dto.SavingsAccountDTO;
import br.com.foursys.fourpay.model.Account;
import br.com.foursys.fourpay.model.Client;
import br.com.foursys.fourpay.model.SavingsAccount;
import br.com.foursys.fourpay.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;


// Controller aciona o service e aciona o repository
// Crossorigin permite acessar de qualquer fonte a fonte
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/account")

public class AccountController {
    final AccountService accountService;

    public AccountController(AccountService accountService) {

        this.accountService = accountService;
    }
    @Autowired
    ClientController clientController;
    // Não definimos uri pois ja foi setado a nivel de classe /account
    // ReponseEntity e para montar resposta com status e corpo e colocou object por causa dos diferentes tipos de retorno
    // Recebemos o dto para  salvar todos os campos que cliente envia e seja salvo
    // RequestBody para receber o corpo do Json, @Valid valida no momento de chegada de dados
    // Caso cliente envie algo não valido ele já receberá um bad request
    // var pode ser usado dentro de um escopo fechado ao inves de Account = new Account(); novidade do jdk sem ser o 8
    // Metodo save não existe, precisa criar ele para receber o account e retorna o mesmo com o uuid

    @PostMapping
    public ResponseEntity<Object> saveAccount(@RequestBody @Valid AccountDto accountDto){
        var account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        account.setRegistrationDateAccount(LocalDateTime.now(ZoneId.of("UTC")));
        account.setClient(clientController.getById(accountDto.getClientId()).get());
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(account));

    }
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.findAll());
    }

    @GetMapping("/{id}")

    public ResponseEntity<Object> getOneAccount(@PathVariable(value = "id")Integer id){


        Optional<Account> accountOptional = accountService.findById(id);
        if (!accountOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(accountOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAccount(@PathVariable(value = "id")Integer id, @RequestBody @Valid AccountDto accountDto){

        Optional<Account> accountOptional = accountService.findById(id);
        if(!accountOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");
        }
        var account = accountOptional.get();
        account.setBalance(accountDto.getBalance());
        return ResponseEntity.status(HttpStatus.OK).body(accountService.save(account));
    }


    public void createCheckingsAccountFromClientCreation(Client client) {
        Account account = new Account();
        account.setBalance(0.0);
        account.setClient(client);
        account.setRegistrationDateAccount(LocalDateTime.now(ZoneId.of("UTC")));
        account.setAgency(determineAgency());
        account.setNumber(determineNumber(accountService.findAll().size()));
        accountService.createCheckingsAccount(account);
    }

    @PostMapping("/savings")
    public ResponseEntity<Object> saveSavingsAccount(@RequestBody @Valid SavingsAccountDTO SavingsAccountDto) {
        var savingsAccount = new SavingsAccount();
        BeanUtils.copyProperties(SavingsAccountDto, savingsAccount);
        savingsAccount.setRegistrationDateAccount(LocalDateTime.now(ZoneId.of("UTC")));
        savingsAccount.setClient(clientController.getById(SavingsAccountDto.getClientId()).get());
        savingsAccount.setAgency(determineAgency());
        savingsAccount.setNumber(determineNumber(accountService.findAll().size()));
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createSavingsAccount(savingsAccount));
    }
    private String determineNumber(Integer size) {
        size = size + 1;
        return "10000" + size.toString();
    }

    private String determineAgency() {
        return "001";
    }
}

