package br.com.foursys.fourpay.controllers;

import br.com.foursys.fourpay.dto.DepositDto;
import br.com.foursys.fourpay.dto.PixTransferDTO;
import br.com.foursys.fourpay.dto.TransferDTO;
import br.com.foursys.fourpay.dto.WithdrawDto;
import br.com.foursys.fourpay.enums.TransactionType;
import br.com.foursys.fourpay.model.Account;
import br.com.foursys.fourpay.model.Transaction;
import br.com.foursys.fourpay.service.PixService;
import br.com.foursys.fourpay.service.TransactionService;
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

    @PostMapping("/pix/transfer")
    public Object transferPix(@RequestBody PixTransferDTO pixTransferDTO){
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
