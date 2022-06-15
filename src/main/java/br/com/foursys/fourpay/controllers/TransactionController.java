package br.com.foursys.fourpay.controllers;

import br.com.foursys.fourpay.dto.DepositDto;
import br.com.foursys.fourpay.dto.TransferDTO;
import br.com.foursys.fourpay.dto.WithdrawDto;
import br.com.foursys.fourpay.model.Account;
import br.com.foursys.fourpay.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired private TransactionService transactionService;
    @PostMapping("/deposit")
    public Object DepositValue(@RequestBody DepositDto depositDto){
        return transactionService.depositValue(depositDto.getAccountId(), depositDto.getDepositValue());
    }

    @PostMapping("/withdraw")
    public Object withdrawValue(@RequestBody WithdrawDto withdrawDto){
        return transactionService.withdrawValue(withdrawDto.getAccountId(), withdrawDto.getWithdrawValue());
    }
    @PostMapping("/transfer")
    public Object transferValue(@RequestBody TransferDTO transferDTO){
        return transactionService.transferValue(transferDTO.getPayerId(), transferDTO.getReceiverId(), transferDTO.getTransferValue());
    }

}
