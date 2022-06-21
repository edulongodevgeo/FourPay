package com.fourcamp.fourpay.repository;

import com.fourcamp.fourpay.model.Recharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechargeRepository extends JpaRepository<Recharge, Integer> {

}

