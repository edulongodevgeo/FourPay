package br.com.foursys.fourpay.controllers;


import br.com.foursys.fourpay.dto.AccountDto;
import br.com.foursys.fourpay.model.Account;
import br.com.foursys.fourpay.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;


// Controller aciona o service e aciona o repository
// Crossorigin permite acessar de qualquer fonte a fonte
@RestController
@RequestMapping("/account")

public class AccountController {
    final AccountService accountService;

    public AccountController(AccountService accountService) {

        this.accountService = accountService;
    }

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
        account.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(account));
    }
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.findAll());
    }



}

