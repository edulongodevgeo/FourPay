package br.com.foursys.fourpay.service;

import br.com.foursys.fourpay.model.Policy;
import br.com.foursys.fourpay.repository.PolicyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.transaction.Transactional;
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


    @Transactional
    public Policy save(Policy policy) {
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


