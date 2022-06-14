package br.com.foursys.fourpay.service;

import br.com.foursys.fourpay.model.Insurance;
import br.com.foursys.fourpay.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceService {
        @Autowired
        private InsuranceRepository insuranceRepository;

//   public Insurance registerInsurence(String name, String rules){
//   Insurance insurance = new Insurance();
//            insurance.setName(name);
//            insurance.setName(rules);
//            return repository.save(insurance);
//        }

    public List<Insurance> getAllInsurance(){
        return insuranceRepository.findAll();
    }
    public Optional<Insurance> getInsuranceId(Integer id){
        return insuranceRepository.findById(id);
    }
    public Insurance addInsurance(Insurance insurance){
        return insuranceRepository.save(insurance);
    }
    public void deleteInsurance(Integer id){
         insuranceRepository.deleteById(id);
    }
    public Insurance updateClient(Integer id, Insurance insurance){
        insurance.setId(id);
        return insuranceRepository.save(insurance);
    }

}
