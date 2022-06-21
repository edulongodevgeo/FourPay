package com.fourcamp.fourpay.controllers;

import com.fourcamp.fourpay.dto.RechargeDTO;
import com.fourcamp.fourpay.enums.TransactionType;
import com.fourcamp.fourpay.model.Recharge;
import com.fourcamp.fourpay.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recharge")
public class RechargeController {

    @Autowired
    RechargeService rechargeService;

    @PostMapping
    public ResponseEntity<Recharge> recharge(@RequestBody RechargeDTO rechargeDTO) {
        Recharge recharge = new Recharge();
        recharge.setCellphoneProvider(rechargeDTO.getCellphoneProvider());
        recharge.setCellphoneNumber(rechargeDTO.getCellphoneNumber());
        recharge.setValue(rechargeDTO.getValue());
        if(!rechargeDTO.getPaymentMethod().equals(TransactionType.DEPOSIT) || !rechargeDTO.getPaymentMethod().equals(TransactionType.WITHDRAW)) {
            recharge.setPaymentMethod(rechargeDTO.getPaymentMethod());
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(rechargeService.recharge(recharge));
    }
}
