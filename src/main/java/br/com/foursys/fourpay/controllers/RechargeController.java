package br.com.foursys.fourpay.controllers;

import br.com.foursys.fourpay.dto.RechargeDTO;
import br.com.foursys.fourpay.model.Recharge;
import br.com.foursys.fourpay.service.RechargeService;
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
    public ResponseEntity<Object> recharge(@RequestBody RechargeDTO rechargeDTO) {
        Recharge recharge = new Recharge();
        recharge.setCellphoneProvider(rechargeDTO.getCellphoneProvider());
        recharge.setCellphoneNumber(rechargeDTO.getCellphoneNumber());
        recharge.setValue(rechargeDTO.getValue());
        recharge.setPaymentMethod(rechargeDTO.getPaymentMethod());

        return ResponseEntity.status(HttpStatus.CREATED).body(rechargeService.recharge(recharge));
    }
}
