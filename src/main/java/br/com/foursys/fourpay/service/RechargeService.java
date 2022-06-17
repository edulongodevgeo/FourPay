package br.com.foursys.fourpay.service;

import br.com.foursys.fourpay.model.Recharge;
import br.com.foursys.fourpay.model.Transaction;
import br.com.foursys.fourpay.repository.RechargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RechargeService {
    @Autowired
    RechargeRepository rechargeRepository;
    @Autowired
    TransactionService transactionService;
    public Object recharge(Recharge recharge) {
        transactionService.rechargeCellPhone(recharge);
        return rechargeRepository.save(recharge);
    }
}
