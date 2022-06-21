package com.fourcamp.fourpay.controllers;


import com.fourcamp.fourpay.dto.PolicyDTO;
import com.fourcamp.fourpay.model.Policy;
import com.fourcamp.fourpay.service.CardService;
import com.fourcamp.fourpay.service.InsuranceService;
import com.fourcamp.fourpay.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RestController
@CrossOrigin(origins = "*", maxAge = 2000)
@RequestMapping("/policy")
public class PolicyController {

    final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @Autowired
    CardService cardService;

    @Autowired
    InsuranceService insuranceService;

    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicy(){
        return ResponseEntity.status(HttpStatus.OK).body(policyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> getById(@PathVariable(value = "id")UUID id){
        Optional<Policy> policyOptional = policyService.findById(id);
        if (!policyOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(policyOptional.get());
    }

    @PostMapping
    public ResponseEntity<Policy> savePolicy(@RequestBody @Valid PolicyDTO policyDTO){
        var policy = new Policy();
        policy.setValuePolicy(200.0);
        policy.setId(UUID.randomUUID());
        policy.setInsurance(insuranceService.getInsuranceId(policyDTO.getInsurance()).get());
        policy.setCreditCard(cardService.findCreditById(policyDTO.getCreditCard()));
        policy.setDatePolicy(LocalDate.now());
        policy.setConditionsDescriptions("Para mais informações ligue para 0800-1234-1234.");
        return ResponseEntity.status(HttpStatus.CREATED).body(policyService.save(policy));
    }
    @DeleteMapping("/{id}")
    public String deletPolicy(@PathVariable UUID id){
        policyService.deletePolicy(id);
        return "Police numero: " + id + " deletada";
    }
}
