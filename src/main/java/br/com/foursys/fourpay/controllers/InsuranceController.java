package br.com.foursys.fourpay.controllers;


import br.com.foursys.fourpay.model.Insurance;
import br.com.foursys.fourpay.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;
    @GetMapping("/{id}")
    public Insurance getById(@PathVariable Integer id){
        return insuranceService.getInsuranceId(id).get();
    }
    @PostMapping
    public Insurance save(@RequestBody Insurance insurance) {
        return insuranceService.addInsurance(insurance);
    }
}
