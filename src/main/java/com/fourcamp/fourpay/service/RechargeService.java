package com.fourcamp.fourpay.service;

import com.fourcamp.fourpay.model.Recharge;
import com.fourcamp.fourpay.repository.RechargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RechargeService {
    @Autowired
    RechargeRepository rechargeRepository;
    @Autowired
    TransactionService transactionService;
    public Recharge recharge(Recharge recharge) {
        transactionService.rechargeCellPhone(recharge);
        return rechargeRepository.save(recharge);
    }
}
