package com.fourcamp.fourpay.service;

import com.fourcamp.fourpay.model.Policy;
import com.fourcamp.fourpay.repository.PolicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PolicyService {
    final PolicyRepository policyRepository;

    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

//    public List<Policy> findAll() {
//        return policyRepository.findAll();
//    }
//
//    public Object getPolicyById(Integer id) {
//        return null;
//    }
//
//    public Object getPolicyByPolicyNumber(Integer policyNumber) {
//        return null;
//    }


        public Policy save(Policy policy) {
        List<Policy> policyList = policyRepository.findAll();
        for (Policy item : policyList) {
            if (item.getCreditCard().getCardNumber().equals(policy.getCreditCard().getCardNumber())) {
                return null;
            }
        }
        return policyRepository.save(policy);
    }

    public Optional<Policy> findById(UUID id) {
        return policyRepository.findById(id);
    }

    public List<Policy> findAll() {
        return policyRepository.findAll();

    }


    public void deletePolicy(UUID id) {
        policyRepository.deleteById(id);
    }
}


