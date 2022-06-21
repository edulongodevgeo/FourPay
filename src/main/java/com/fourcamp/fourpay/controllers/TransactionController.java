package com.fourcamp.fourpay.controllers;

import com.fourcamp.fourpay.dto.DepositDto;
import com.fourcamp.fourpay.dto.PixTransferDTO;
import com.fourcamp.fourpay.dto.TransferDTO;
import com.fourcamp.fourpay.dto.WithdrawDto;
import com.fourcamp.fourpay.enums.TransactionType;
import com.fourcamp.fourpay.model.Transaction;
import com.fourcamp.fourpay.service.PixService;
import com.fourcamp.fourpay.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired private TransactionService transactionService;
    @Autowired
    PixService pixService;
    @PostMapping("/deposit")
    public Transaction DepositValue(@RequestBody DepositDto depositDto){
        return transactionService.depositValue(depositDto.getAccountId(), depositDto.getDepositValue());
    }

    @PostMapping("/withdraw")
    public Transaction withdrawValue(@RequestBody WithdrawDto withdrawDto){
        return transactionService.withdrawValue(withdrawDto.getAccountId(), withdrawDto.getWithdrawValue());
    }
    @PostMapping("/transfer")
    public Transaction transferValue(@RequestBody TransferDTO transferDTO){
        return transactionService.transferValue(transferDTO.getPayerId(), transferDTO.getReceiverId(), transferDTO.getTransferValue());
    }

    @PostMapping("/pix/transfer")
    public Transaction transferPix(@RequestBody PixTransferDTO pixTransferDTO){
        Transaction transaction = new Transaction();
        transaction.setDescription("Transferência de pix");
        transaction.setValue(pixTransferDTO.getValue());
        transaction.setDateOfTransaction(LocalDateTime.now());
        transaction.setTransactionType(TransactionType.PIX);
        transaction.setPayerId(pixTransferDTO.getPayerId());
        transaction.setReceiverId(pixService.getPixByKeyValueAndKeyType(pixTransferDTO.getKeyValue(), pixTransferDTO.getKeyType()));
        if(transaction.getReceiverId() == null){
            return null;
        }
        return transactionService.transferPix(transaction);
    }
    
    @GetMapping("/statement/") 
        public List<Transaction> getAll(){
    		return transactionService.getAllTransaction();    	
    }
    
    @GetMapping("/statement/{id}") 
    public List<Transaction> getById(@PathVariable Integer id){
		return transactionService.getByIdTransaction(id);    	
}


}
