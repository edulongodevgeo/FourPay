package br.com.foursys.fourpay.repository;

import br.com.foursys.fourpay.model.Recharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechargeRepository extends JpaRepository<Recharge, Integer> {

}

