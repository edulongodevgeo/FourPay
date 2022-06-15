package br.com.foursys.fourpay.controllers;


import br.com.foursys.fourpay.dto.PolicyDTO;
import br.com.foursys.fourpay.model.CreditCard;
import br.com.foursys.fourpay.model.Policy;
import br.com.foursys.fourpay.service.CardService;
import br.com.foursys.fourpay.service.InsuranceService;
import br.com.foursys.fourpay.service.PolicyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Object> getById(@PathVariable(value = "id")UUID id){
        Optional<Policy> policyOptional = policyService.findById(id);
        if (!policyOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Policy not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(policyOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> savePolicy(@RequestBody @Valid PolicyDTO policyDTO){
        var policy = new Policy();
        policy.setConditionsDescriptions("Condições exemplo");
        policy.setValuePolicy(200.0);
        policy.setId(UUID.randomUUID());
        policy.setInsurance(insuranceService.getInsuranceId(policyDTO.getInsurance()).get());
        policy.setCreditCard(cardService.findCreditById(policyDTO.getCreditCard()).get());
        return ResponseEntity.status(HttpStatus.CREATED).body(policyService.save(policy));
    }
    @DeleteMapping("/{id}")
    public String deletPolicy(@PathVariable UUID id){
        policyService.deletePolicy(id);
        return "Police numero: " + id + " deletada";
    }
}
