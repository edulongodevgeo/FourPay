package com.fourcamp.fourpay.controllers;


import com.fourcamp.fourpay.model.Insurance;
import com.fourcamp.fourpay.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
