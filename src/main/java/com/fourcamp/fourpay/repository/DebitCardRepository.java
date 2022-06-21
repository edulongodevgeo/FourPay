package com.fourcamp.fourpay.repository;

import com.fourcamp.fourpay.model.DebitCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitCardRepository extends JpaRepository<DebitCard, Integer> {
}
