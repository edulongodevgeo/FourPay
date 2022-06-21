package com.fourcamp.fourpay.repository;

import com.fourcamp.fourpay.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository <CreditCard, Integer> {
}
